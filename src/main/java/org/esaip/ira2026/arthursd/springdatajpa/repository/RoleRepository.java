package org.esaip.ira2026.arthursd.springdatajpa.repository;

import org.esaip.ira2026.arthursd.springdatajpa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
