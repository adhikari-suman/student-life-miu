package lesson4.exercise_3;

public class Employee {
	private String name;
	private int salary;
	public Employee() {
		//creates an Employee shell
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(int sal) {
		this.salary = sal;
	}
	@Override
	public String toString() {
		return name + ": " + salary;
	}
}




