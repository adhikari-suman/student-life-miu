package edu.miu.lab4partb.repository;

import edu.miu.lab4partb.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
