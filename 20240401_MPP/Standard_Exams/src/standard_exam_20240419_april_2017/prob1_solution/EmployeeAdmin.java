package standard_exam_20240419_april_2017.prob1_solution;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeAdmin {

	// returns a list of social security numbers, sorted in ascending order,
	// that belong to an Employee in the input table but that are not on the
	// socSecNums input list
	public static List<String> prepareSsnReport(HashMap<String, Employee> table, List<String> socSecNums) {
		//implement
		// set for removing O(m^n) operation to O(n)
		Set<String> socSecNumsSet = new HashSet<>(socSecNums);

		return table.keySet()
				.stream()
				.filter(ssn -> !socSecNumsSet.contains(ssn))
		.collect(Collectors.toList());
				
	}			
		//return a list of Employees whose social security number is on the input list socSecNums
				//and whose salary is >80000; the return list does not need to be sorted  
	public static List<Employee> prepareEmpReport(HashMap<String, Employee> table, List<String> socSecNums) {
		//implement
		Set<String> socSecNumsSet = new HashSet<>(socSecNums);

		return table
				.entrySet()
				.stream()
				.filter(e -> socSecNumsSet.contains(e.getKey()))
				.map(Map.Entry::getValue)
				.filter(e-> e.getSalary() > 80_000)
				.collect(Collectors.toList());
	}
}