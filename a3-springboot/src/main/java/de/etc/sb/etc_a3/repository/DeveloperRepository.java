package de.etc.sb.etc_a3.repository;

import de.etc.sb.etc_a3.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    // findAll, ... inclusive

    Optional<Developer> findByName(String name);
}