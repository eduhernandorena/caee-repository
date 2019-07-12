package br.org.fiergs.caeeservice.repositories;

import br.org.fiergs.caeeservice.entities.Caee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaeeRepository extends JpaRepository<Caee, Long> {

    Optional<Caee> findByNameContainingIgnoreCase(String name);

    Optional<Caee> findOneByNameIgnoreCaseAndIdNot(String name, Long id);

    void deleteById(Long id);
}
