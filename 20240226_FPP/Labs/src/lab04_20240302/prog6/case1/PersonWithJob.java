package lab04_20240302.prog6.case1;

import java.util.GregorianCalendar;

public class PersonWithJob extends Person {
	private double salary;

	PersonWithJob(String n, GregorianCalendar dob, double s) {
		super(n, dob);
		this.salary = s;
	}

	public double getSalary() {
		return salary;
	}
}