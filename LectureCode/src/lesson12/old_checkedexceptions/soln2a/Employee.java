package lesson12.old_checkedexceptions.soln2a;

import java.util.Date;

//write exception-handling code in a catch block

class Employee {
	Date hireDate = new Date();

	public Object makeCopy() {
		try {
			Employee copy = (Employee) super.clone();
			copy.hireDate = (Date) hireDate.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			System.err.println("Unable to make a copy");
		}
		return null;
	}

}
