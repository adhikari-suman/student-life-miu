package lesson2.basics.typicalprogramtest;

import static org.junit.Assert.*;

import org.junit.Test;

import lesson2.basics.typicalprogram.Address;

public class TestAddress {
	/** Test that formatted string representation of address is correct */
	@Test
	public void testToString() {
		Address addr = new Address("10 Adams", "Fairfield", "IA", "52556");
		assertEquals("String version of address not formatted properly",
				"10 Adams, Fairfield, IA 52556",
				addr.toString());
		
	}
}
