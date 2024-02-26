package lesson3.employee.rogue_j8soln;

import java.time.LocalDate;
import java.util.*;

public class Rogue {
	public static void main(String[] args) {
		
		Employee harry = new Employee("Harry", "Rogers", 50000, 1989, 10, 1);
		LocalDate d = harry.getHireDay();
		Date theDate = new GregorianCalendar(d.getYear(), 
				d.getMonthValue(),
				d.getDayOfMonth()).getTime();

		
		// Original hire date is Oct 1, 1989
		System.out.println("Original hire date " + String.format("%tD", theDate));
		
		long tenYearsInMilliseconds = 10 * 365 * 24 * 60 * 60 * 1000L;
		long time = theDate.getTime();
		// Hire date after rogue programmer modifies
		theDate.setTime(time - tenYearsInMilliseconds);
		System.out.println("Harry's hire date after rogue " + String.format("%tD",
				new GregorianCalendar(harry.getHireDay().getYear(), 
						harry.getHireDay().getMonthValue(),
						harry.getHireDay().getDayOfMonth()).getTime()));
	}
}
