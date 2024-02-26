package lesson4.overrides;

public class Manager extends Employee {
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}
	@Override
	public double getSalary() {
		// no direct access to private variables of superclass
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double b) {
		bonus = b;
	}

	private double bonus;
}
