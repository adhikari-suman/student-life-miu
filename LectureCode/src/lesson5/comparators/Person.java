package lesson5.comparators;

public class Person {
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
