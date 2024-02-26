package lesson5_innersort4;

import java.util.Arrays;
import java.util.Comparator;

/** Processes person data. Makes use of an inner class NameComparator */
public class PersonData {

	public static void main(String[] args) {
		PersonData pd = new PersonData();
		Person[] persons = prepareData();
		pd.sort(persons);
		System.out.println(Arrays.toString(persons));
	}
	
	private void sort(Person[] persons) {
		class NameComparator implements Comparator<Person>{
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		}
		Arrays.sort(persons, new NameComparator());
	}
	
	static Person[] prepareData() {
		Person[] persons = {new Person("Joe"), new Person("Bob"), new Person("Anne")};
		return persons;
	}
	
	
	
}
