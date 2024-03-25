package lab08_20240313.prog3.employeesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeSort {

	public static void main(String[] args) {
		new EmployeeSort();

	}

	public EmployeeSort() {
		Employee[] empArray = { new Employee("George", 40000, 1996, 11, 5), new Employee("Dave", 50000, 2000, 1, 3),
				new Employee("Richard", 45000, 2001, 2, 7) };
		List<Employee> empList = Arrays.asList(empArray);
		NameComparator nameComp = new NameComparator();
		Collections.sort(empList, nameComp);

		System.out.println(empList);

		System.out.println("\n\n=================== Start - Sort by Salary ===================\n\n");

		Employee[] empArray1 = { new Employee("Ariel", 40000, 1996, 11, 5), new Employee("Ariel", 50000, 1996, 11, 5),
				new Employee("Ariel", 45000, 1996, 11, 5) };
		List<Employee> empList1 = Arrays.asList(empArray1);
		SalaryComparator salaryComp = new SalaryComparator();
		Collections.sort(empList1, salaryComp);
		System.out.println(empList1);

		System.out.println("\n\n=================== Start - Sort by Salary ===================\n\n");

		
		System.out.println("\n\n=================== Start - Sort by Hire Date ===================\n\n");

		Employee[] empArray2 = { new Employee("Ariel", 40000, 1996, 2, 5), new Employee("Ariel", 50000, 1956, 2, 7),
				new Employee("Ariel", 45000, 1994, 4, 5) };
		List<Employee> empList2 = Arrays.asList(empArray2);
		HireDateComparator hireDateComp = new HireDateComparator();
		Collections.sort(empList2, hireDateComp);
		System.out.println(empList2);

		System.out.println("\n\n=================== Start - Sort by Hire Date ===================\n\n");
	}

}
