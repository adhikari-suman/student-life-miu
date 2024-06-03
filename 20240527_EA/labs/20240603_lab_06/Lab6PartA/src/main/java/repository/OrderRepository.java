package repository;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

@Query("SELECT DISTINCT o.orderNumber FROM Order o WHERE o.status= 'closed'")
    public List<String> findDistinctOrdersByStatusClosed();

    @Query("SELECT DISTINCT o.orderNumber FROM Order o WHERE o.customer " +
            ".address" +
            ".city= :city")
    public List<String> findDistinctOrdersByCity(String city);
}
