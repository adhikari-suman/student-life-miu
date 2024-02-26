package lesson4.equals.simpleexample.bad;

class Person {
	private String name;
	Person(String n) {
		name = n;
	}
	
	public static void main(String[] args) {
		Person joe1 = new Person("Joe");
		Person joe2 = new Person("Joe");
		System.out.println("Is it true that joe1.equals(joe2)? "
			+ joe1.equals(joe2));
	}
}

