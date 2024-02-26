package lesson4.comparable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;


class Employee implements Comparable<Employee> {
	private String name;
	private int salary;
	private LocalDate hireDay;
	// constructor
	Employee(String aName, int aSalary, int aYear, int aMonth, int aDay) {
		name = aName;
		salary = aSalary;
		hireDay = LocalDate.of(aYear,  aMonth, aDay);
	}

	// instance methods
	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += Math.round(raise);
	}
	
	@Override
	public String toString() {
		return name + " " + salary;
	}

	@Override
	public int compareTo(Employee e) {
		if(getSalary() < e.getSalary()) return -1;
		else if(getSalary() > e.getSalary()) return 1;
		else { //getSalary() == e.getSalary()
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		Employee[] empArray = {new Employee("Bob", 200000, 2009, 5, 5),
				new Employee("Dave", 100000, 2009, 5, 5),
				new Employee("Tim", 150000, 2009, 5, 5) 
		};
				
		Arrays.sort(empArray);
		System.out.println(Arrays.toString(empArray));
	}
	
	
	
}
