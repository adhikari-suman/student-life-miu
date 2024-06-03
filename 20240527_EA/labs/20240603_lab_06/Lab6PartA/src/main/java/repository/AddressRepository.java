package repository;

import domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long > {

    @Query( value = "SELECT * FROM `addresses` a WHERE a.city = 'Amsterdam'",
            nativeQuery = true)
    public List<Address> findAllAddressesInAmsterdam();
}
