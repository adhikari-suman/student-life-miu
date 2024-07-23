package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.clearDB();
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		System.out.println(customerRepository.getCustomer(101));
		System.out.println(customerRepository.getCustomer(66));
		System.out.println("-----------All customers ----------------");
		System.out.println(customerRepository.getAllCustomers());


		Product p1 = new Product(1,"iPhone 15", 899.99);
		Product p2 = new Product(2,"iPhone 15 Pro", 999.99);
		Product p3 = new Product(3,"iPhone 15 Max", 1199.99);

		Supplier apple = new Supplier(1, "Apple Inc", "1-800-APPL");

		p1.setSupplier(apple);
		p2.setSupplier(apple);
		p3.setSupplier(apple);

		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);

		System.out.println("\n-----------All products ----------------");
		System.out.println(productRepository.getAllProducts());

		System.out.println("----------- Found products by Id ----------------");
		System.out.println(productRepository.findByProductNumber(1));
		System.out.println(productRepository.findByProductNumber(3));

		productRepository.removeProduct(1);

		System.out.println("-----------All products ----------------");
		System.out.println(productRepository.getAllProducts());
	}

}
