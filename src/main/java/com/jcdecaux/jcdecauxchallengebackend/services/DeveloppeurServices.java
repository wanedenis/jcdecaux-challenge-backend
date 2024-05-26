package com.jcdecaux.jcdecauxchallengebackend.services;

import com.jcdecaux.jcdecauxchallengebackend.models.Developpeur;
import com.jcdecaux.jcdecauxchallengebackend.models.DeveloppeurDto;
import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import com.jcdecaux.jcdecauxchallengebackend.models.LanguageDto;

import java.util.List;

public interface DeveloppeurServices {

    public Developpeur createDeveloppeur(DeveloppeurDto developpeur);

    public Developpeur updateDeveloppeur(DeveloppeurDto developpeur, Long id);

    public List<Developpeur> getListDeveloppeurs(String language);

    public boolean addLanguageToDeveloppeur(LanguageDto language, Long developpeurId);

}
