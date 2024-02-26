package lesson3.callbyvalueorreference;

public class ChangeValueInReference {
	public static void main(String[] arg) {
		ChangeValueInReference c = new ChangeValueInReference();
		Employee harry = new Employee("Harry","Rogers", 50000, 1989, 10, 1);
		c.tripleSalary(harry);
		//salary has been tripled
		System.out.println("Harry's salary now: " + harry.getSalary());
	}

	public void tripleSalary(Employee e) {
		e.raiseSalary(200);
	}
}

