package lesson3.employee;


public class EmployeeTest {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl", "Jones", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry", "Rogers", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony", "Atkinson", 40000, 1990, 3, 15);

		
		// From EmployeeTest -- can access raiseSalary method
		for (Employee e : staff) {
			e.raiseSalary(5);
		}
		for (Employee e : staff) {
			System.out.printf(e.toString() + "%n");
		}
		//shows how private variables are not accessible
		//staff[0].name;
	}	
}
