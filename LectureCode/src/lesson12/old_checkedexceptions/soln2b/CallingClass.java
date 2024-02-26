package lesson12.old_checkedexceptions.soln2b;

public class CallingClass {
	void callingMethod() throws CloneNotSupportedException {
		Employee e = new Employee();
		e.makeCopy(); 
	}
}
