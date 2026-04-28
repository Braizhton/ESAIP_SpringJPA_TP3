package org.esaip.ira2026.arthursd.springdatajpa.repository;

import org.esaip.ira2026.arthursd.springdatajpa.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    // Cherche par nom commun exact
    Optional<Species> findByCommonName(String commonName);

    // Cherche par nom commun OU nom latin
    List<Species> findByCommonNameOrLatinName(String commonName, String latinName);

    // Cherche les espèces dont le nom commun commence par un certain préfixe
    List<Species> findByCommonNameStartingWith(String prefix);

    // Jointure inversée : trouve l'espèce qui possède un animal avec un nom spécifique
    List<Species> findByAnimalsName(String animalName);
}
