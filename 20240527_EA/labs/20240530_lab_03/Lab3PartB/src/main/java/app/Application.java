package app;

import domain.Book;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.BookRepository;
import repository.CustomerRepository;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerRepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerRepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerRepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerRepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerRepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();


		/**
		 * Create 3 books, and save them in the database
		 * - Retrieve all books from the database and display them in the console
		 * - Update a book
		 * - Delete a book (not the book that was just updated)
		 * - Retrieve all books from the database again and display them in the console
		 */
		bookRepository.save(new Book(1,"Harry Potter: I", "ISBN#HP1","J. K. Rowlings", 12.99));
		bookRepository.save(new Book(2,"Harry Potter: II", "ISBN#HP2","J. K. Rowlings", 15.99));
		bookRepository.save(new Book(3,"Harry Potter: III", "ISBN#HP1","J. K. Rowlings", 19.99));

		// Retrieve all books from the database and display them in the console
		for(Book book: bookRepository.findAll()){
			System.out.println(book);
		}
		System.out.println();

		// Update a book
		Book book = bookRepository.findById(1).orElse(null);

		if(book != null){
			book.setPrice(4.99);
			book.setAuthor("Not J.K. Rowlings");

			bookRepository.save(book);
		}

		// Delete a book
		if(bookRepository.findById(3).isPresent()){
			bookRepository.deleteById(3);
		}

		// Retrieve all books from the database and display them in the console
		for(Book b: bookRepository.findAll()){
			System.out.println(b);
		}
		System.out.println();

	}

}
