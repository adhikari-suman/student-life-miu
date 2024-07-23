package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import repository.AddressRepository;
import repository.CDRepository;
import repository.CustomerRepository;
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
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"repository"})
@EntityScan(basePackages = {"domain"})
public class Application implements CommandLineRunner {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CDRepository cDRepository;
    @Autowired
    private AddressRepository addressRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        createData();

        /**
         * Query by method names
         */

        // Give all  customers.

        System.out.println("\n----------- START:: METHOD BASED QUERIES " +
                "-----------");

        System.out.println("\n----------- All Customers -----------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }

        // Give all CD’s from U2 with a price smaller than 10 euro
        System.out.println("\n----------- All CD’s from U2 with a price " +
                "smaller than 10 euro -----------");
        for (CD cd : cDRepository.findDistinctByArtistAndPriceLessThan("U2", 10)) {
            System.out.println(cd);
        }

        System.out.println("\n----------- END:: METHOD BASED QUERIES " +
                "-----------");


        System.out.println("\n\n----------- START:: NAMED QUERIES " +
                "-----------");

        System.out.println("\n----------- All Customers from USA -----------");
        for (Customer customer : customerRepository.allCustomersFromUSA()) {
            System.out.println(customer);
        }

        System.out.println("\n----------- All CDs from U2 -----------");
        for (CD cd : cDRepository.allFromU2()) {
            System.out.println(cd);
        }

        System.out.println("\n\n----------- END:: NAMED QUERIES " +
                "-----------");

        System.out.println("\n\n----------- START:: JPQL QUERIES " +
                "-----------");

        System.out.println("\n----------- ordernumbers of all orders with status ‘closed’ -----------");
        for (String orderNumber : orderRepository.findDistinctOrdersByStatusClosed()) {
            System.out.println(orderNumber);
        }


        System.out.println("\n----------- first and lastnames of all customers who live in Amsterdam -----------");
        for (String fullName :
                customerRepository.firstAndLastNameOfAllCustomersLivingInAmsterdam()) {
            System.out.println(fullName);
        }

        System.out.println("\n----------- ordernumbers of all orders from " +
                "customers who live in a certain :city -----------");
        for (String orderNumber : orderRepository.findDistinctOrdersByCity(
                "New York")) {
            System.out.println(orderNumber);
        }

        System.out.println("\n----------- CD’s from a certain :artist with a " +
                "price bigger than a certain :amount  -----------");
        for (CD cd : cDRepository.findAllBy("U2", 2.5)) {
            System.out.println(cd);
        }

        System.out.println("\n\n----------- END:: JPQL QUERIES " +
                "-----------");

        System.out.println("\n\n----------- START:: NATIVE QUERIES " +
                "-----------");

        System.out.println("\n----------- All addresses in Amsterdam " +
                "-----------");
        for(Address address:addressRepository.findAllAddressesInAmsterdam()){
            System.out.println(address);
        }

        System.out.println("\n----------- All CDs from U2 -----------");
        for (CD cd : cDRepository.allFromU2Natives()) {
            System.out.println(cd);
        }

        System.out.println("\n\n----------- END:: NATIVE QUERIES " +
                        "-----------");
    }


    @Transactional
    public void createData() {
        // Create addresses
        Address address1 = new Address("Street 1", "Amsterdam", "12345", "Netherlands");
        Address address2 = new Address("Street 2", "New York", "54321", "USA");
        Address address3 = new Address("Street 3", "London", "67890", "UK");

        // Create customers
        Customer customer1 = new Customer("John", "Doe", address1, new ArrayList<>());
        Customer customer2 = new Customer("Jane", "Smith", address2, new ArrayList<>());
        Customer customer3 = new Customer("Michael", "Brown", address3, new ArrayList<>());

        // Create products (CDs)
        CD cd1 = new CD("CD001", "CD Title 1", 9.99, "U2");
        CD cd2 = new CD("CD002", "CD Title 2", 12.99, "U2");
        CD cd3 = new CD("CD003", "CD Title 3", 8.99, "Coldplay");

        // Create orders
        Order order1 = new Order("ORD001", LocalDateTime.now(), "closed", new ArrayList<>(), customer1);
        Order order2 = new Order("ORD002", LocalDateTime.now(), "open", new ArrayList<>(), customer2);

        // Create order lines
        OrderLine orderLine1 = new OrderLine(2L, cd1);
        OrderLine orderLine2 = new OrderLine(1L, cd2);
        OrderLine orderLine3 = new OrderLine(3L, cd3);

        order1.setOrderLines(Arrays.asList(orderLine1, orderLine2));
        order2.setOrderLines(Arrays.asList(orderLine3));


        // Add orders to customers
        customer1.setOrders(Arrays.asList(order1));
        customer2.setOrders(Arrays.asList(order2));

        customerRepository.saveAll(Arrays.asList(customer1, customer2,
                customer3));
    }

}
