package org.esaip.ira2026.arthursd.springdatajpa.repository;

import org.esaip.ira2026.arthursd.springdatajpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // --- Requêtes simples sur les attributs ---

    // Récupérer un utilisateur par son login (qui est unique d'après ton entité)
    Optional<Person> findByLogin(String login);

    // Cherche toutes les personnes actives (utilise IsTrue ou True)
    List<Person> findByActiveTrue();

    // Cherche toutes les personnes inactives
    List<Person> findByActiveFalse();

    // Comparaison numérique : personnes de plus de X ans (inclus)
    List<Person> findByAgeGreaterThanEqual(Integer age);

    // Comparaison numérique : personnes dont l'âge est entre X et Y
    List<Person> findByAgeBetween(Integer minAge, Integer maxAge);


    // --- Requêtes avec jointures (ManyToMany) ---

    // Jointure simple sur Role : trouve les personnes ayant un label de rôle précis
    List<Person> findByRolesLabel(String roleLabel);

    // Jointure simple sur Animal : trouve les personnes possédant un animal d'une certaine couleur
    List<Person> findByAnimalsColor(String color);

    // Jointure profonde (Person -> Animal -> Species) :
    // Trouve les personnes qui possèdent un animal d'une certaine espèce !
    List<Person> findByAnimalsSpeciesCommonName(String commonName);
}
