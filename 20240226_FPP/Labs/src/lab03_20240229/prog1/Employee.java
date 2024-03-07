package lab03_20240229.prog1;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

//same as the Employee class defined in the lecture
public class Employee {
//instance fields
	private String name;
	private String nickName;
	private double salary;
	private LocalDate hireDay;

//constructor
	public Employee(String aName, String aNickName, double aSalary, int aYear, int aMonth, int aDay) {
		name = aName;
		nickName = aNickName;
		salary = aSalary;
		hireDay = LocalDate.of(aYear, aMonth, aDay);
	}

//instance methods
	public String getName() {
		return name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String aNickName) {
		nickName = aNickName;
	}

	public double getSalary() {
		return salary;
	}

//needs to be improved
	public LocalDate getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	private String format = "name = %s, salary = %.2f, hireDay = %s";

	public String toString() {
		return String.format(format, name, salary, hireDay);
	}
}