package midterm.practice_202040309.immutable;

public class Employee {
	private final Integer id;

	private final String name;

	private final Double salary;

	private Employee(Integer id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public static void main() {
		Employee e = new Employee(1, "Ariel", 140_000D);

		final int a;

		a = 7;

		// a= 8; // error

	}

}
