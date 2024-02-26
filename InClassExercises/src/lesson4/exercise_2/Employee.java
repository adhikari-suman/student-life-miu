package lesson4.exercise_2;

public class Employee {
	private String name;
	private int salary;
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return name + " " + salary;
	}
	
	public static void main(String[] args) {
		Employee e = new Employee("Bob", 85000);
		System.out.println(e);
	}
}


