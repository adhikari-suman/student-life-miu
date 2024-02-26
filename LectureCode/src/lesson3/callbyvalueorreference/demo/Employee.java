package lesson3.callbyvalueorreference.demo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	// instance fields
	private String name; 
	private String nickName;
	private double salary;
	private Date hireDay;

	// constructor
	Employee(String aName, String aNickName, double aSalary, int aYear,
			int aMonth, int aDay) {
		name = aName;
		nickName = aNickName;
		salary = aSalary;
		GregorianCalendar cal = new GregorianCalendar(aYear, aMonth - 1, aDay);
		hireDay = cal.getTime();
	}

	// instance methods
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
	// needs to be improved
	public Date getHireDay() {
		return hireDay;
	}
	
	//From Advanced Employee example
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
