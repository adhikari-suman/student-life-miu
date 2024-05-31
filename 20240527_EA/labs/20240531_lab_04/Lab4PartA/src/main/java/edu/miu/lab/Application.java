package edu.miu.lab;

import edu.miu.lab.domain.*;
import edu.miu.lab.repository.BookRepository;
import edu.miu.lab.repository.DepartmentRepository;
import edu.miu.lab.repository.PassengerRepository;
import edu.miu.lab.repository.SchoolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = {"edu.miu.lab"})
public class Application implements CommandLineRunner {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PassengerRepository passengerRepository;

    @Autowired
    private SchoolRepository schoolRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// Create a dept
		Department d1 = new Department(null, "Sales",new ArrayList<>());

		// Create employees
		Employee e1 = new Employee(null, 1L, "Ariel", d1);

		// add employee to department
		d1.getEmployees().add(e1);

		// save dept
		departmentRepository.save(d1);

		System.out.println("------------- All departments -------------");
		for(Department d : departmentRepository.findAll()) {
			System.out.println(d);
		}

		/**
		 * Books and Publishers
		 */

		Publisher p = new Publisher(null, "Amazon Publications");

		Book book = new Book(null, "isbn#1", "Harry Potters & PoA", "J.K. Rowlings", null);

		Book book2 = new Book(null, "isbn#2", "Let Us C++", "Y. Kanetkar", null);

		book2.setPublisher(p);

		bookRepository.save(book);
		bookRepository.save(book2);

		System.out.println("------------- All books -------------");
		for(Book b : bookRepository.findAll()) {
			System.out.println(b);
		}

		/**
		 * Flights and Passengers
		 */
		Passenger passenger = new Passenger(null,"Ariel");
		passenger.setFlights(new ArrayList<>());

		Flight f2 = new Flight(
				null,
				"#2",
				"Chicago",
				"Texas",
				LocalDateTime.of(2024, Month.APRIL, 12, 12, 24, 0)
		);

		Flight f1 = new Flight(
				null,
				"#1",
				"Iowa",
				"Chicago",
				LocalDateTime.of(2024, Month.APRIL, 11, 23, 11, 0)
		);

		passenger.getFlights().add(f1);
		passenger.getFlights().add(f2);

		passengerRepository.save(passenger);

		System.out.println("------------- All passengers -------------");
		for (Passenger pass : passengerRepository.findAll()) {
			System.out.println(pass);
		}

		/**
		 * School and Students
		 */


		Student s1 = new Student(null, "123", "Ariel","Adhikari");
		Student s2 = new Student(null, "245", "Allen", "Walker");

		School school = new School(null,"MIU", new HashMap<>());

		school.getStudents().put(s1.getStudentid(), s1);
		school.getStudents().put(s2.getStudentid(), s2);

		schoolRepository.save(school);

		System.out.println("------------- All schools -------------");
		for(School sch : schoolRepository.findAll()) {
			System.out.println(sch);
		}



	}
}
