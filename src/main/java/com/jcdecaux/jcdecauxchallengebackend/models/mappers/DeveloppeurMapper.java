package com.jcdecaux.jcdecauxchallengebackend.models.mappers;

import com.jcdecaux.jcdecauxchallengebackend.models.Developpeur;
import com.jcdecaux.jcdecauxchallengebackend.models.DeveloppeurDto;
import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface DeveloppeurMapper {

    DeveloppeurMapper INSTANCE = Mappers.getMapper(DeveloppeurMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "languages", target = "languages")
    DeveloppeurDto developpeurToDeveloppeurDto(Developpeur developpeur);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "languages", target = "languages")
    Developpeur developpeurDtoToDeveloppeur(DeveloppeurDto developpeur);

    default List<Language> map(Set<Language> languages) {
        return new ArrayList<>(languages);
    }

    default Set<Language> map(List<Language> languages) {
        return new HashSet<>(languages);
    }
}
