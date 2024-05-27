package com.jcdecaux.jcdecauxchallengebackend.services;

import com.jcdecaux.jcdecauxchallengebackend.models.Developpeur;
import com.jcdecaux.jcdecauxchallengebackend.models.DeveloppeurDto;
import com.jcdecaux.jcdecauxchallengebackend.models.LanguageDto;

import java.util.List;

public interface DeveloppeurServices {

    Developpeur createDeveloppeur(DeveloppeurDto developpeur);

    Developpeur updateDeveloppeur(DeveloppeurDto developpeur, Long id);

    List<Developpeur> getListDeveloppeurs(String language);

    Developpeur addLanguageToDeveloppeur(LanguageDto language, Long developpeurId);

}
