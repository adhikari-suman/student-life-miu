package lab11_20240318.prog1;

import java.util.HashMap;
import java.util.Iterator;

public class Employee {
	private String firstName;
	private String lastName;
	private HashMap<String, Double> salaryRecord;

	public Employee() {
		salaryRecord = new HashMap<>();
	}

	public void addEntry(String date, double salary) {
		// implement
		this.salaryRecord.put(date, salary);
	}

	public void printPaymentAmount(String date) {
		// implement
		Double salary = salaryRecord.get(date);
		String format;

		if (salary == null) {
			format = "%s %s did not receive a paycheck on %s";

			System.out.println(String.format(format, firstName, lastName, date));
		} else {
			format = "%s %s was paid %.1f on %s";

			System.out.println(String.format(format, firstName, lastName, salary, date));
		}

	}

	public void printAveragePaycheck() {
		// implement
		Double totalSalary = 0D;

		for (var entry : salaryRecord.entrySet()) {
			totalSalary += entry.getValue();
		}

		Double avgSalary = salaryRecord.size() == 0 ? 0D : totalSalary / salaryRecord.size();

		System.out.println(String.format("Average paycheck for %s %s was %.1f", firstName, lastName, avgSalary));
	}

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setFirstName("Jim");
		e.setLastName("Jones");
		for (int i = 1; i <= 12; ++i) {
			e.addEntry(i + "/15/2011", 3070 + 5 * i);
		}
		e.printPaymentAmount("3/15/2011");
		e.printPaymentAmount("5/15/2010");
		e.printAveragePaycheck();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
