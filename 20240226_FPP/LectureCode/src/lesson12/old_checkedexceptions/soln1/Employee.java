package lesson12.old_checkedexceptions.soln1;

import java.util.Date;

class Employee implements Cloneable {
	Date hireDate = new Date();

	public Object makeCopy() throws CloneNotSupportedException {
		Employee copy = (Employee) super.clone();
		copy.hireDate = (Date) hireDate.clone();
		return copy;

	}

}
