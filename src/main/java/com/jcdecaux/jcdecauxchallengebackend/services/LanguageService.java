package com.jcdecaux.jcdecauxchallengebackend.services;

import com.jcdecaux.jcdecauxchallengebackend.models.Developpeur;
import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import com.jcdecaux.jcdecauxchallengebackend.models.LanguageDto;

import java.util.List;

public interface LanguageService {

    public Language createLanguage(LanguageDto language);

    public List<Language> getListLanguages();

}
