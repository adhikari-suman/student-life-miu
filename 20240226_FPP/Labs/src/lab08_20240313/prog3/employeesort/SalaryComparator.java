package lab08_20240313.prog3.employeesort;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {

		int diffSalary = o1.getSalary() -o2.getSalary();
		
		if(diffSalary!=0) {
			return diffSalary;
		}
		
		
		// now salary is equal, check name
		if(o1.getName().compareTo(o2.getName())!= 0) {
			return o1.getName().compareTo(o2.getName());
		}
		
		// now salary and name are equal, check hiredate
		return o1.getHireDate().compareTo(o2.getHireDate());
		
		

	}

}
