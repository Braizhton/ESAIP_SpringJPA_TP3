package org.esaip.ira2026.arthursd.springdatajpa.repository;

import org.esaip.ira2026.arthursd.springdatajpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
