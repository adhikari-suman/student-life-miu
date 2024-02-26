package lesson3.employee.rogue;

import java.util.Date;

public class Rogue {
	public static void main(String[] args) {
		
		Employee harry = new Employee("Harry", "Rogers", 50000, 1989, 10, 1);
		Date d = harry.getHireDay();
		
		// Original hire date is Oct 1, 1989
		System.out.println("Original hire date " 
		    + String.format("%tD", d.getTime()));
		
		long tenYearsInMilliseconds = 10 * 365 * 24 * 60 * 60 * 1000L;
		long time = d.getTime();
		// Hire date after rogue programmer modifies
		d.setTime(time - tenYearsInMilliseconds);
		
		// The hire date stored in object harry has been modifed
		System.out.println("Hacked hire date " 
		    + String.format("%tD", harry.getHireDay().getTime()));
	}
}
