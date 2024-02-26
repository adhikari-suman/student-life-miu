package lesson3.callbyvalueorreference;

public class BasicExample {
	Employee emp = new Employee("Alice","Thompson", 60000, 1995, 2, 10);
	
	public static void main(String[] args) {
		BasicExample be = new BasicExample();
		be.raiseSalary(be.emp, 0.20);  //emp's salary has been raised
		be.tryToChangeReference(be.emp);  //emp points to the same object as before
	}
	private void raiseSalary(Employee e, double percent) {
		e.raiseSalary(percent);
	}
	private void tryToChangeReference(Employee e) {
		e = new Employee("Bob","Rogers", 70000, 1997, 10, 1);
	}
}


