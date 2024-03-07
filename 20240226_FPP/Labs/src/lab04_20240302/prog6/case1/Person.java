package lab04_20240302.prog6.case1;

import java.util.GregorianCalendar;

public class Person {
	private String name;
	private GregorianCalendar dateOfBirth;

	Person(String name, GregorianCalendar dob) {
		this.name = name;
		dateOfBirth = dob;
	}

	public String getName() {
		return name;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public boolean equals(Object o) {

		if (o == null || !(o instanceof Person)) {
			return false;
		}
		Person p = (Person) o;

		boolean isEqual = name.equals(p.name) && p.dateOfBirth.equals(this.dateOfBirth);

		return isEqual;
	}

}
