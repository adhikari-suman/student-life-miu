package lab08_20240313.prog3.employeesort;

import java.util.Comparator;

public class HireDateComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {

		// check date
		int hireDateDiff = o1.getHireDate().compareTo(o2.getHireDate());

		
		if (hireDateDiff != 0) {
			return hireDateDiff;
		}

		// hire date is equal, check names
		if (o1.getName().compareTo(o2.getName()) != 0) {
			return o1.getName().compareTo(o2.getName());
		}

		// hire date and name are equal, check salary
		return o1.getSalary() - o2.getSalary();

	}

}
