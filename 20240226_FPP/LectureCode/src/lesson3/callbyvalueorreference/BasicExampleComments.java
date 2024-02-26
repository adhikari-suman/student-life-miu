package lesson3.callbyvalueorreference;

public class BasicExampleComments {
	Employee emp = new Employee("Alice","Thompson", 60000, 1995, 2, 10);
	
	public static void main(String[] args) {
	
		BasicExampleComments be = new BasicExampleComments();
	
		//Can update the object referenced by emp by calling methods or
		//accessing variables directly using dot notation
		be.raiseSalary(be.emp, 0.20);  //emp's salary has been raised
		
		//Cannot change the reference stored in emp with a method call
		be.tryToChangeReference(be.emp);  //emp points to the same object as before
	}
	private void raiseSalary(Employee e, double percent) {
		e.raiseSalary(percent);
	}
	private void tryToChangeReference(Employee e) {
		//Variable e is destroyed after method exits; no change 
		//of reference in the emp variable occurs
		e = new Employee("Bob","Rogers", 70000, 1997, 10, 1);
	}
}
