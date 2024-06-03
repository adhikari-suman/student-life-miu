package repository;

import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findAll();

    public List<Customer> allCustomersFromUSA();


    @Query("SELECT DISTINCT CONCAT(c.firstName, ' ', c.lastName) FROM " +
            "Customer c JOIN c.address a WHERE c.address.city='Amsterdam'")
    public List<String> firstAndLastNameOfAllCustomersLivingInAmsterdam();
}
