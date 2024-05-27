package com.jcdecaux.jcdecauxchallengebackend.services.impls;

import com.jcdecaux.jcdecauxchallengebackend.models.Developpeur;
import com.jcdecaux.jcdecauxchallengebackend.models.DeveloppeurDto;
import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import com.jcdecaux.jcdecauxchallengebackend.models.LanguageDto;
import com.jcdecaux.jcdecauxchallengebackend.models.mappers.DeveloppeurMapper;
import com.jcdecaux.jcdecauxchallengebackend.repositories.DeveloppeurRepository;
import com.jcdecaux.jcdecauxchallengebackend.repositories.LanguageRepository;
import com.jcdecaux.jcdecauxchallengebackend.services.DeveloppeurServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeveloppeurServicesImpl implements DeveloppeurServices {

    private final DeveloppeurRepository developpeurRepository;
    private final LanguageRepository languageRepository;

    public DeveloppeurServicesImpl(DeveloppeurRepository developpeurRepository, LanguageRepository languageRepository) {
        this.developpeurRepository = developpeurRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public Developpeur createDeveloppeur(DeveloppeurDto developpeur) {

        if (developpeur != null &&
                    developpeur.getNom() != null &&
                    developpeur.getPrenom() != null){

            return developpeurRepository
                    .save(DeveloppeurMapper.INSTANCE.developpeurDtoToDeveloppeur(developpeur));
        }

        return null;
    }

    @Override
    public Developpeur updateDeveloppeur(DeveloppeurDto dev, Long id) {

        Developpeur _developpeur = developpeurRepository.findById(id).orElseThrow();

        if (dev != null &&
                dev.getNom() != null &&
                dev.getPrenom() != null){

            _developpeur.setNom(dev.getNom());
            _developpeur.setPrenom(dev.getPrenom());

            return developpeurRepository.save(_developpeur);
        }

        return null;
    }

    @Override
    public List<Developpeur> getListDeveloppeurs(String language) {

        List<Developpeur> devs = developpeurRepository.findAll();

        if (language != null){
            devs = devs.stream().filter(dev -> dev.getLanguages()
                    .stream().anyMatch(l -> l.getNom().equalsIgnoreCase(language))
            ).collect(Collectors.toList());
        }

        return devs;
    }

    @Override
    public Developpeur addLanguageToDeveloppeur(LanguageDto language, Long developpeurId) {

        if (language != null){

            Optional<Language> _language = languageRepository.findLanguageByNom(language.getNom());
            //.orElseThrow(() -> new RuntimeException("Language not found"));

            if (_language.isPresent()){

                Optional<Developpeur> dev = developpeurRepository.findById(developpeurId);
                //.orElseThrow(() -> new RuntimeException("Developpeur not found"));

                if (dev.isPresent()){

                    Developpeur _developpeur = dev.get();

                    if (!_developpeur.getLanguages().contains(_language.get())) {
                        _developpeur.getLanguages().add(_language.get());
                        developpeurRepository.save(_developpeur);
                        return _developpeur;
                    }

                }

            }

        }

        return null;
    }

}
