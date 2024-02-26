package lesson1.testcalculatesum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Testing {
	
	@Test
	public void testCalculateSum() {
		int[] arr = {1,2,3};
		int expected = 6;
		int result = SampleClass.calculateSum(arr);
		assertTrue(expected == result);
		//assertEquals(expected, result);
	}
}
