package lesson3.callbyvalueorreference.demo;

public class ChangeValueInReference {
	public static void main(String[] arg) {
		ChangeValueInReference c = new ChangeValueInReference();
		Employee harry = new Employee("Harry","Rogers", 50000, 1989, 10, 1);
		c.tripleSalary(harry);
		//What is harry's salary now?
		System.out.println("Harry's salary now: " + harry.getSalary());
		//System.out.println(harry);
	}

	public void tripleSalary(Employee e) {
		//System.out.println(e);
		e.raiseSalary(200);
	}
}

