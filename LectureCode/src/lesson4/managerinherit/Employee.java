package lesson4.managerinherit;

import java.time.LocalDate;

class Employee {
	//instance fields
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	// constructor
	Employee(String aName, double aSalary, int aYear, int aMonth, int aDay) {
		name = aName;
		salary = aSalary;
		hireDay = LocalDate.of(aYear, aMonth, aDay);
	}

	// instance methods
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	public static void main(String[] args) {
		Employee emp = new Manager("Pete", 100000, 2009, 11, 5);
		//Manager inherits non-private methods from Employee
		System.out.printf("Name: %s\n",emp.getName());
		System.out.printf("Salary: %.2f\n", emp.getSalary());
		
		//When typed as an Employee, the Manager loses access to methods specific to Manager class
		//emp.getBonus() //compiler error
		
		//Can downcast to Manager to get Manager functionality (generally a bad practice)
		Manager m = (Manager)emp;
		m.setBonus(100);
		System.out.println(emp.getSalary());
	}
}
