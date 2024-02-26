package lesson12.old_checkedexceptions.soln2c;

public class CallingClass {
	void callingMethod() throws ApplicationSpecificException {
		Employee e = new Employee();
		e.makeCopy(); 
	}
}
