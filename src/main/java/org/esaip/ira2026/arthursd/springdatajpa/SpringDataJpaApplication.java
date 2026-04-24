package org.esaip.ira2026.arthursd.springdatajpa;

import org.esaip.ira2026.arthursd.springdatajpa.model.Species;
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

    @Autowired
    public SpringDataJpaApplication(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== FIND ALL ===");
        List<Species> all = speciesRepository.findAll();
        all.forEach(System.out::println);

        System.out.println("\n=== SAVE NEW ENTITIES ===");
        Species s1 = new Species(null, "Cheval", "Equus ferus caballus");
        Species s2 = new Species(null, "Vache", "Bos taurus");

        Species saved = speciesRepository.save(s1);
        speciesRepository.save(s2);

        System.out.println("After save:");
        speciesRepository.findAll().forEach(System.out::println);

        System.out.println("\n=== FIND BY ID ===");

        Optional<Species> found = speciesRepository.findById(saved.getId());
        found.ifPresent(System.out::println);

        System.out.println("\n=== DELETE ===");
        speciesRepository.deleteById(s2.getId());

        System.out.println("After delete:");
        List<Species> afterDelete = speciesRepository.findAll();
        afterDelete.forEach(System.out::println);

        System.out.println("\nTotal species: " + afterDelete.size());
    }
}
