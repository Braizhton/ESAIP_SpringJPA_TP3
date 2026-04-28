package org.esaip.ira2026.arthursd.springdatajpa;

import org.esaip.ira2026.arthursd.springdatajpa.model.Animal;
import org.esaip.ira2026.arthursd.springdatajpa.model.Person;
import org.esaip.ira2026.arthursd.springdatajpa.model.Role;
import org.esaip.ira2026.arthursd.springdatajpa.model.Species;
import org.esaip.ira2026.arthursd.springdatajpa.repository.AnimalRepository;
import org.esaip.ira2026.arthursd.springdatajpa.repository.PersonRepository;
import org.esaip.ira2026.arthursd.springdatajpa.repository.RoleRepository;
import org.esaip.ira2026.arthursd.springdatajpa.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
    private final SpeciesRepository speciesRepository;
    private final AnimalRepository animalRepository;
    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public SpringDataJpaApplication(SpeciesRepository speciesRepository,
                                    AnimalRepository animalRepository,
                                    PersonRepository personRepository,
                                    RoleRepository roleRepository) {
        this.speciesRepository = speciesRepository;
        this.animalRepository = animalRepository;
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        // =============================================
        // 1. Afficher toutes les entités avec findAll
        // =============================================
        System.out.println("===== Toutes les espèces =====");
        List<Species> allSpecies = speciesRepository.findAll();
        allSpecies.forEach(System.out::println);

        System.out.println("\n===== Tous les animaux =====");
        List<Animal> allAnimals = animalRepository.findAll();
        allAnimals.forEach(System.out::println);

        System.out.println("\n===== Toutes les personnes =====");
        List<Person> allPersons = personRepository.findAll();
        allPersons.forEach(System.out::println);

        System.out.println("\n===== Tous les rôles =====");
        List<Role> allRoles = roleRepository.findAll();
        allRoles.forEach(System.out::println);

        // =============================================
        // 2. Créer de nouvelles entités avec save
        // =============================================
        System.out.println("\n===== Création d'une nouvelle espèce =====");
        Species poney = new Species();
        poney.setCommonName("Poney");
        poney.setLatinName("Fortis equus visae");
        poney = speciesRepository.save(poney);
        System.out.println("Espèce créée : " + poney);

        System.out.println("\n=== Création de nouvelles espèces ===");
        Species cheval = new Species(null, "Cheval", "Equus ferus caballus");
        Species vache = new Species(null, "Vache", "Bos taurus");
        cheval = speciesRepository.save(cheval);
        vache = speciesRepository.save(vache);

        System.out.println("\n===== Création d'un nouvel animal =====");
        Animal pinpin = new Animal();
        pinpin.setName("Pinpin");
        pinpin.setColor("Blanc");
        pinpin.setSex("M");
        pinpin.setSpecies(poney);
        pinpin = animalRepository.save(pinpin);
        System.out.println("Animal créé : " + pinpin);

        // =============================================
        // 3. Rechercher par id avec findById
        // =============================================
        System.out.println("\n===== Recherche d'un animal par ID =====");
        Optional<Animal> animalOpt = animalRepository.findById(pinpin.getId());
        if (animalOpt.isPresent()) {
            System.out.println("Animal trouvé : " + animalOpt.get());
        } else {
            System.out.println("Animal non trouvé !");
        }

        // =============================================
        // 4. Supprimer des entités avec delete
        // =============================================
        System.out.println("\n===== Suppression de l'animal créé =====");
        animalRepository.delete(pinpin);
        System.out.println("Animal supprimé !");

        System.out.println("Nombre d'animaux après suppression : " + animalRepository.count());

        // Supprimer aussi l'espèce créée
        System.out.println("\n===== Suppression de l'espèce créée =====");
        speciesRepository.delete(poney);
        System.out.println("Espèce supprimée !");
        System.out.println("Nombre d'espèces après suppression : " + speciesRepository.count());

        System.out.println("\n===== Suppression des autres espèces créées =====");
        speciesRepository.delete(cheval);
        speciesRepository.delete(vache);
        System.out.println("Autres espèces supprimées !");
        System.out.println("Nombre d'espèces après suppression : " + speciesRepository.count());
    }
}
