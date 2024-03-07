package lab04_20240302.prog6.case3;

import java.util.GregorianCalendar;

public class PersonWithJob {
	private Person person;
	private double salary;

	PersonWithJob(String name, GregorianCalendar dob, double salary) {
		person = new Person(name, dob);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
	
	public Person getPerson() {
		return new Person(person.getName(), person.getDateOfBirth());
	}
	
	
	@Override
	public boolean equals(Object o) {
		
		if(o == null || ! (o instanceof PersonWithJob)) {
			return false;
		}
		
		PersonWithJob p = (PersonWithJob)o;
		
		// Selector/Getter not used since still inside of same class
		// Better practice to use Getter instead of private fields
		return Math.abs(p.salary - salary) < 0.00001
				&& p.person.equals(person);
	}
}
