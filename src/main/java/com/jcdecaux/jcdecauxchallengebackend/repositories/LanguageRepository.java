package com.jcdecaux.jcdecauxchallengebackend.repositories;


import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    Optional<Language> findLanguageByNom(String nom);

}
