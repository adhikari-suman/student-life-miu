package lesson12.old_checkedexceptions.problem;

import java.util.Date;

class Employee implements Cloneable {
	Date hireDate = new Date();

	public Object makeCopy() {
//		Employee copy = (Employee) super.clone();
//		copy.hireDate = (Date) hireDate.clone();
//		return copy;

		return null;

	}

}
