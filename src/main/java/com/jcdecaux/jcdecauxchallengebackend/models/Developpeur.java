package com.jcdecaux.jcdecauxchallengebackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Developpeur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "developpeur_language",
            joinColumns = { @JoinColumn(name = "developpeur_id") },
            inverseJoinColumns = { @JoinColumn(name = "language_id") })
    private Set<Language> languages = new HashSet<>();

    public void addLanguage(Language language) {
        this.languages.add(language);
        language.getDeveloppeurs().add(this);
    }

    public void removeLanguage(long languageId) {
        Language language = this.languages.stream().filter(t -> t.getId() == languageId)
                .findFirst().orElse(null);

        if (language != null) {
            this.languages.remove(language);
            language.getDeveloppeurs().remove(this);
        }
    }

}
