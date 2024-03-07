package lesson3.exercise_1;

import java.time.LocalDate;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Date date = dateFromLocalDate(LocalDate.of(1970, 1, 1));
		Date date2 = dateFromLocalDate(LocalDate.of(1970, 1, 3));
		long numHours = (long)((date2.getTime() - date.getTime())/(1000 * 60 * 60)); //implement
		
		
		//output numHours to the console

		System.out.printf("Num. hrs: %d", numHours);
	}

	public static Date dateFromLocalDate(LocalDate localDate) {	
		int year = localDate.getYear();
		int month = localDate.getMonth().getValue() - 1;
		int day = localDate.getDayOfMonth();
	
		
		return new Date(year, month, day);
	}
}
