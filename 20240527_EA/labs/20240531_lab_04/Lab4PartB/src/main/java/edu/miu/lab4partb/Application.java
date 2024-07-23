package edu.miu.lab4partb;

import edu.miu.lab4partb.domain.Address;
import edu.miu.lab4partb.domain.Customer;
import edu.miu.lab4partb.domain.OrderLine;
import edu.miu.lab4partb.domain.Order;
import edu.miu.lab4partb.domain.Product;
import edu.miu.lab4partb.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = {"edu.miu.lab4partb"})
public class Application implements CommandLineRunner {


    private final OrderRepository orderRepository;

    public Application(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Create an address
        Address address = new Address("1000 N 4th St.", "Fairfield", "52557","USA");

        // Create a person
        Customer customer = new Customer(
                "Ariel",
                "Adhikari",
                address,
                new ArrayList<>()
        );


        // Create a Product
        Product p1 = new Product("123","iPhone 12 Pro Max", 1199.99);
        Product p2 = new Product("133","iPhone 14 Pro Max", 1399.99);

        // Create an order line
        OrderLine ol1 = new OrderLine(3L, p1);
        OrderLine ol2 = new OrderLine(1L, p2);

        // Create an order
        Order o = new Order(
                "#1",
                LocalDateTime.of(2024, Month.APRIL, 12, 12,43,0),
                "Shipped",
                new ArrayList<>(List.of(ol1, ol2)),
                customer

        );

       orderRepository.save(o);


        System.out.println("-------------- All Orders -------------- ");
        for(Order order: orderRepository.findAll()){
            System.out.println(order);
        }


    }
}
