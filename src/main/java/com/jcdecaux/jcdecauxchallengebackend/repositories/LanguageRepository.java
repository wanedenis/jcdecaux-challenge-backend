package com.jcdecaux.jcdecauxchallengebackend.repositories;


import com.jcdecaux.jcdecauxchallengebackend.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    List<Language> findLanguageByDeveloppeursId(Long developpeurId);

}
