package lesson12.old_checkedexceptions.soln1;

/*
 * Solution 1: Do not attempt to handle directly
 * instead, declare that your method throws this kind of exception too
 */
public class CallingClass {
	void callingMethod() throws CloneNotSupportedException {
		Employee e = new Employee();
		e.makeCopy(); 
	}
}
