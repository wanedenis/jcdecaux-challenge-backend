package com.jcdecaux.jcdecauxchallengebackend.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeveloppeurDto {

    private Long id;
    private String nom;
    private String prenom;
    private List<Language> languages = new ArrayList<>();

}
