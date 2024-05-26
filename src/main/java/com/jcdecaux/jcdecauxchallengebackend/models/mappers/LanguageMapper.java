package com.jcdecaux.jcdecauxchallengebackend.models.mappers;

import com.jcdecaux.jcdecauxchallengebackend.models.Developpeur;
import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import com.jcdecaux.jcdecauxchallengebackend.models.LanguageDto;
import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface LanguageMapper {

    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "developpeurs", target = "developpeurs")
    LanguageDto languageToLanguageDto(Language language);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "developpeurs", target = "developpeurs")
    Language languageDtoToLanguage(LanguageDto language);

    default List<Developpeur> map(Set<Developpeur> developpeurs) {
        return new ArrayList<>(developpeurs);
    }

    default Set<Developpeur> map(List<Developpeur> developpeurs) {
        return new HashSet<>(developpeurs);
    }
}
