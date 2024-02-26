package lesson2.basics.typicalprogram;

/**
 * Creates a few Employees, stores them in an array.
 * Then locates all Employees with first name Bill
 * 
 * @author pcorazza
 * @since Jan 2016
 *
 */
public class Main {

	public static void main(String[] args) {
		Address add1A = new Address("10 Adams", "Fairfield", "IA", "52556");
		Address add1B = new Address("110 Burlington", "Fairfield", "IA", "52556");
		Address add2A = new Address("322 Harrison", "Fairfield", "IA", "52556");
		Address add2B = new Address("2210 Burlington", "Fairfield", "IA", "52556");
		Employee e1 = new Employee("Joe", "Smith");
		e1.setSalary(100000);
		e1.setHome(add1A);
		e1.setWork(add1B);
		e1.setChristmasBonus(50);
		Employee e2 = new Employee();
		e2.setSalary(120000);
		e2.setHome(add2A);
		e2.setWork(add2B);
		
		//Prints info about Employee 1
		System.out.println(e1.toString());
		System.out.println(" Home address: " + e1.getHome().toString());
		System.out.println(" Work address: " + e1.getWork().toString());
		
		//Creates an Employee array of length 2
		Employee[] empArray = new Employee[2];
		empArray[0] = e1;
		empArray[1] = e2;
		
		/*
		 * Searches the array for an Employee having first name "Bill".
		 * If found, prints out the Employee's full name
		 */
		for(int i = 0; i < empArray.length; ++i) {
			String firstName = empArray[i].getFirstName();
			if(firstName.equals(Employee.IMPORTANT_FIRST)) {
				System.out.println("Found the Boss! " + empArray[i].toString());
			}
		}
		
	}

}
