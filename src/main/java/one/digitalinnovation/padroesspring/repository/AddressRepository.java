package one.digitalinnovation.padroesspring.repository;

import one.digitalinnovation.padroesspring.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
