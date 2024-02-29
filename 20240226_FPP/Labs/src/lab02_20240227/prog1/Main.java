package lab02_20240227.prog1;

public class Main {

	public static void main(String[] args) {
		// 1. Create address and customer
		Address add1A = new Address("121 N. LaSalle Street", "Chicago", "IL", "60602");
		Address add1B = new Address("121 N. LaSalle Street", "Chicago", "IL", "60602");
		Address add2A = new Address("322 Harrison", "Fairfield", "IA", "52556");
		Address add2B = new Address("2210 Burlington", "Fairfield", "IA", "52556");
		
		Customer cust1 = new Customer(
				"Suman", 
				"Adhikari", 
				"619-123-4444"
				);
		cust1.setBillingAddress(add1A);
		cust1.setShippingAddress(add1B);
		
		Customer cust2 = new Customer(
				"Binod", 
				"Rasaili", 
				"619-123-4424"
				);
		
		cust2.setBillingAddress(add2A);
		cust2.setShippingAddress(add2B);
		
		// 2. create customer array
		Customer[] customers = new Customer[] {cust1, cust2};
		
		// 3. print all customers with billing address in Chicago city
		for(Customer c:customers) {
			if(c.getBillingAddress().getCity() == "Chicago") {
				System.out.println(c);
			}
		}

	}

}
