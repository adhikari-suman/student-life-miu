package lesson1.testcalculatesum;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestSampleClass {
	@Test
	public void testCalculateSum() {
		int[] testArray = {1, 2, 3};
		int result = SampleClass.calculateSum(testArray);
		int expected = 1 + 2 + 3;
		assertTrue(expected == result);
	}
}


