package com.jcdecaux.jcdecauxchallengebackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
                @UniqueConstraint(columnNames = "nom")
        })
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "languages")
    @JsonBackReference
    private Set<Developpeur> developpeurs = new HashSet<>();

    public void addDeveloppeur(Developpeur developpeur) {
        this.developpeurs.add(developpeur);
        developpeur.getLanguages().add(this);
    }

    public void removeDeveloppeur(long developpeurId) {
        Developpeur developpeur = this.developpeurs
                .stream().filter(t -> t.getId() == developpeurId).findFirst().orElse(null);

        if (developpeur != null) {
            this.developpeurs.remove(developpeur);
            developpeur.getLanguages().remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language language)) return false;
        return Objects.equals(getId(), language.getId())
                && Objects.equals(getNom(), language.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

}
