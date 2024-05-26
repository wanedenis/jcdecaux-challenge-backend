package com.jcdecaux.jcdecauxchallengebackend.repositories;


import com.jcdecaux.jcdecauxchallengebackend.models.Developpeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloppeurRepository extends JpaRepository<Developpeur, Long> {
}
