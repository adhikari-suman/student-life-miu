package lab04_20240302.prog1;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Create professors
		Professor p1 = new Professor("Ankhtuya Ochirbat", 240000, LocalDate.of(2015, 12, 15),10 );
		Professor p2 = new Professor("Jeff Peterson", 240000, LocalDate.of(2010, 12, 1),10 );
		Professor p3 = new Professor("Timothy Eagleson", 240000, LocalDate.of(2017, 1, 12),10 );

		// Create secretaries
		Secretary s1 = new Secretary("Whitney", 240000, LocalDate.of(2015, 3, 15),200);
		Secretary s2 = new Secretary("Lisa", 240000, LocalDate.of(2016, 4, 12),200);
		
		// Create array of DeptEmployees
		DeptEmployee[] department = new DeptEmployee[5];
		
		department[0] = p1;
		department[1] = p2;
		department[2] = p3;
		department[3] = s1;
		department[4] = s2;
		
		// Ask user for showing sum of all salaries
		Scanner sc = new Scanner(System.in);
		System.out.print("Do you wish to see the sum of all salaries?[Y/N] ");
		String  input = sc.next();
		
		if(!input.equalsIgnoreCase("y")) {
			return;
		}
		
		double salary = 0.0;
		
		for(DeptEmployee e: department) {
			salary += e.computeSalary();
		}
		
		System.out.printf("Total Salary: %.2f", salary);
		
	}

}
