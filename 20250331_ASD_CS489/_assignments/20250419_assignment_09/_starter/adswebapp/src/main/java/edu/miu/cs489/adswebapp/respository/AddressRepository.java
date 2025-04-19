package edu.miu.cs489.adswebapp.respository;

import edu.miu.cs489.adswebapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
