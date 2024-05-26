package com.jcdecaux.jcdecauxchallengebackend.services.impls;

import com.jcdecaux.jcdecauxchallengebackend.models.Developpeur;
import com.jcdecaux.jcdecauxchallengebackend.models.DeveloppeurDto;
import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import com.jcdecaux.jcdecauxchallengebackend.models.LanguageDto;
import com.jcdecaux.jcdecauxchallengebackend.models.mappers.DeveloppeurMapper;
import com.jcdecaux.jcdecauxchallengebackend.models.mappers.LanguageMapper;
import com.jcdecaux.jcdecauxchallengebackend.repositories.LanguageRepository;
import com.jcdecaux.jcdecauxchallengebackend.services.LanguageService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language createLanguage(LanguageDto language) {

        if (language != null &&
                language.getNom() != null){

            return languageRepository
                    .save(LanguageMapper.INSTANCE.languageDtoToLanguage(language));
        }

        return null;
    }




    @Override
    public List<Language> getListLanguages() {

        return languageRepository.findAll();

    }
}
