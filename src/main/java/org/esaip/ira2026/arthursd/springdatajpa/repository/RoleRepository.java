package org.esaip.ira2026.arthursd.springdatajpa.repository;

import org.esaip.ira2026.arthursd.springdatajpa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // Cherche par le label exact
    Optional<Role> findByLabel(String label);

    // Cherche un rôle contenant un mot (ex: "ADMIN" trouvera "SUPER_ADMIN"), sans tenir compte des majuscules
    List<Role> findByLabelContainingIgnoreCase(String label);

    // Vérifie si un rôle existe (renvoie un booléen, très utile pour les validations)
    boolean existsByLabel(String label);
}
