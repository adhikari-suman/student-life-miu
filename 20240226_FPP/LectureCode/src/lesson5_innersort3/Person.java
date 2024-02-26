package lesson5_innersort3;

import java.util.Arrays;
import java.util.Comparator;

/** Keeps a static nested class Comparator. Comparator behavior does not depend
 *  on the Person's instance variables, so it makes sense to place the Comparator
 *  here as a static nested class
 *
 */
public class Person {
	static class NameComparator implements Comparator<Person>{
		@Override
		public int compare(Person p1, Person p2) {
			return p1.getName().compareTo(p2.getName());
		}
	}
	private String name;

	public Person(String n) {
		name = n;
	}
	public String getName() {
			return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
}
