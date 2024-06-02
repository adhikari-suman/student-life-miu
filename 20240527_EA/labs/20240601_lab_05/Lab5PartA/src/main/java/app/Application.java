package app;

import domain.*;
import repository.OrderRepository;
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
@EnableJpaRepositories(basePackages = {"repository"})
@EntityScan(basePackages = {"domain"})
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


        // Create products

        Book book = new Book("#1", "Atomic Habits", 4.99, "isbn#1");
        CD cd = new CD("#2","8 miles",2.99,"Eminem" );
        DVD dvd = new DVD("#2","8 miles",4.99,"Hip hop" );



        // Create an order line
        OrderLine ol1 = new OrderLine(3L, book);
        OrderLine ol2 = new OrderLine(1L, cd);
        OrderLine ol3 = new OrderLine(1L, dvd);

        // Create an order
        Order o = new Order(
                "#1",
                LocalDateTime.of(2024, Month.APRIL, 12, 12,43,0),
                "Shipped",
                new ArrayList<>(List.of(ol1, ol2, ol3)),
                customer

        );

       orderRepository.save(o);


        System.out.println("-------------- All Orders -------------- ");
        for(Order order: orderRepository.findAll()){
            System.out.println(order);
        }


    }
}
