package lesson3.employee.rogue_j7soln;

import java.util.Date;

public class Rogue {
	public static void main(String[] args) {
		
		Employee harry = new Employee("Harry", "Rogers", 50000, 1989, 10, 1);
		Date d = harry.getHireDay();
		
		// Original hire date is Oct 1, 1989
		System.out.println("Original hire date " + String.format("%tD", d.getTime()));
		
		long tenYearsInMilliseconds = 10 * 365 * 24 * 60 * 60 * 1000L;
		long time = d.getTime();
		// Hire date after rogue programmer modifies
		d.setTime(time - tenYearsInMilliseconds);
		
		// Although the Date d has been modified, it is not one of the fields in harry
		System.out.println("Harry's hire date after rogue " 
		    + String.format("%tD", harry.getHireDay().getTime()));
	}
}
