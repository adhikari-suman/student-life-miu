package lesson5.comparators;

import java.util.Arrays;
import java.util.Comparator;

import lesson5.comparators.data.PersonData;

/** 
 * This version is the same as MainComparator
 * except that the Comparator is defined
 * as an anonymous inner class
 *
 */
public class MainAnonymous {
	public static void main(String[] args) {
		Person[] persons = PersonData.personData;
		Arrays.sort(persons, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});
		System.out.println(Arrays.toString(persons));
	}
}


