package lesson3.employee;

import java.util.Date;

public class Main {

	
	public static void main(String[] args) {
		Employee e = new Employee("Bob", "Bob", 100000, 1999, 5, 5);
		System.out.printf("%tD", e.getHireDay());
		Date d = e.getHireDay();
		d.setTime(0L);
		System.out.printf("\n%tD", e.getHireDay());
		
	}

}
