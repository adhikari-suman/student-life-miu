package lesson2.basics.typicalprogramtest;

import static org.junit.Assert.*;

import org.junit.Test;

import lesson2.basics.typicalprogram.Address;
import lesson2.basics.typicalprogram.Employee;

public class TestEmployee {
	/** Test that formatted string representation of address is correct */
	@Test
	public void testToString() {
		Address addHome = new Address("10 Adams", "Fairfield", "IA", "52556");
		Address addWork = new Address("110 Burlington", "Fairfield", "IA", "52556");
		Employee e1 = new Employee("Joe", "Smith");
		e1.setSalary(100000);
		e1.setHome(addHome);
		e1.setWork(addWork);
		assertEquals("String representation of Employee not as expected",
				"[Joe Smith]",
				e1.toString());
		
	}
}
