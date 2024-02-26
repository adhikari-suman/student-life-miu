package lesson12.old_checkedexceptions.soln2c;

import java.util.Date;

//throw a new kind of exception from within the catch block

class Employee implements Cloneable {
	Date hireDate = new Date();

	public Object makeCopy() throws ApplicationSpecificException {
		try {
			Employee copy = (Employee) super.clone();
			copy.hireDate = (Date) hireDate.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			System.err.println("Unable to make a copy");
			throw new ApplicationSpecificException("cannot make a copy");
		}
	}

}
