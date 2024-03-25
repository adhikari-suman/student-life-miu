package midterm.practice_202040309.dates;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Dates {
	public static void main(String... args) {
		// Date object
		Date date = new Date();
		
		System.out.println(date);
		
		// Gregorian Calendar
		
		GregorianCalendar gc = new GregorianCalendar();
		
		int gcDay = gc.get(Calendar.MINUTE);
		
		System.out.printf("%tD\n",gc);
		System.out.printf("%d\n",gcDay);
		
		// FOrmatter
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		
		System.out.println(df.format(gc.getTime()));
		
		// LocalDate
		LocalDate ld = LocalDate.of(gc.get(Calendar.YEAR),
				gc.get(Calendar.MONTH)+1, gc.get(Calendar.DATE)
				);
		
		System.out.printf("%s\n",ld);
	}
}
