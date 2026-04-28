package org.esaip.ira2026.arthursd.springdatajpa.repository;

import org.esaip.ira2026.arthursd.springdatajpa.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    // Trouve les animaux d'une espèce donnée ET d'un certain sexe
    List<Animal> findBySpeciesCommonNameAndSex(String commonName, String sex);

    // Combinaison : cherche par couleur ET par sexe
    List<Animal> findByColorAndSex(String color, String sex);

    // Jointure : trouve tous les animaux d'une espèce (via son nom commun)
    List<Animal> findBySpeciesCommonName(String commonName);

    // Jointure : trouve tous les animaux d'une espèce (via son nom commun)
    List<Animal> findBySpeciesLatinNameContaining(String latinNamePart);

    // Jointure + Tri : animaux d'une espèce, triés par nom par ordre alphabétique
    List<Animal> findBySpeciesCommonNameOrderByNameAsc(String commonName);

    // Compte le nombre d'animaux pour une couleur donnée
    long countByColor(String color);

    // Cherche les animaux dont le nom contient "pin" (ex: "Pinpin", "Lapin")
    List<Animal> findByNameContainingIgnoreCase(String namePart);
}
