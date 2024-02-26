package lesson5_innersort1;

import java.util.Arrays;

/** Processes person data. Makes use of an external NameComparator class */
public class PersonData {
	
	public static void main(String[] args) {
		Person[] persons = prepareData();
		Arrays.sort(persons, new NameComparator());
		System.out.println(Arrays.toString(persons));
	}
	static Person[] prepareData() {
		Person[] persons = 
			{new Person("Joe"), new Person("Bob"), new Person("Anne")};
		return persons;
	}
}
