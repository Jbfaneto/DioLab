package one.digitalinnovation.padroesspring.repository;

import one.digitalinnovation.padroesspring.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
