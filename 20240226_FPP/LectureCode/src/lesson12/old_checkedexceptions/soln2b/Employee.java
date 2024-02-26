package lesson12.old_checkedexceptions.soln2b;

import java.util.Date;

/*
 * partially handle the exception in a catch block, 
 * and then re-throw the exception to allow other methods 
 * in the call stack to handle it further
 */
class Employee implements Cloneable {
	Date hireDate = new Date();

	public Object makeCopy() throws CloneNotSupportedException {
		try {
			Employee copy = (Employee) super.clone();
			copy.hireDate = (Date) hireDate.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			System.err.println("Unable to make a copy");
			throw e;
		}
	}

}
