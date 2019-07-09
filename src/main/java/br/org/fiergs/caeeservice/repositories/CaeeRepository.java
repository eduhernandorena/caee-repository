package br.org.fiergs.caeeservice.repositories;

import br.org.fiergs.caeeservice.entities.Caee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CaeeRepository extends JpaRepository<Caee, Long> {
    Optional<Caee> findByCode(String code);

    Optional<Caee> findByCodeOrDescription(String code, String description);

    Optional<List<Caee>> findByDescriptionContainingIgnoreCase(String description);

    @Query("select o from Caee o where (upper(description) = upper(?1) or code = ?2) and id <> ?3")
    Optional<Caee> findOneByDescriptionIgnoreCaseOrCodeAndIdNot(String description, String code, Long id);

    void deleteById(Long id);
}
