package org.esaip.ira2026.arthursd.springdatajpa;

import org.esaip.ira2026.arthursd.springdatajpa.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    public void run(String... args) throws Exception {
        // écrire ici nos « tests ».
    }
}
