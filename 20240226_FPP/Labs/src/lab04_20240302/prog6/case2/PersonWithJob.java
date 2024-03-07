package lab04_20240302.prog6.case2;

import java.util.GregorianCalendar;

public class PersonWithJob extends Person {
	private double salary;

	PersonWithJob(String name, GregorianCalendar dob, double salary) {
		super(name, dob);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public boolean equals(Object o) {

		if (o == null || !(o instanceof PersonWithJob)) {
			return false;
		}
		PersonWithJob p = (PersonWithJob) o;

		boolean isEqual = getName().equals(p.getName()) 
				&& p.getDateOfBirth().equals(this.getDateOfBirth())
				&& Math.abs(salary - p.salary) < 0.00001D;

		return isEqual;
	}
}
