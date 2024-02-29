package lab03_20240228.prog8;

import org.junit.Test;
import static org.junit.Assert.*;

public class Prog8Test {
	@Test
	public void testMin() {
		// Arrange
		int[] arr = {2,4,1,7,9}; 
		int expected = 1;
		
		// Act
		int result = Prog8.min(arr);
		
		// Assert
		assertEquals(expected, result);
	}
	
	@Test
	public void testMinOnEmptyArray() {
		// Arrange
		int[] arr = {}; 
		int expected = Integer.MAX_VALUE;
		
		// Act
		int result = Prog8.min(arr);
		
		// Assert
		assertEquals(expected, result);
	}
	
}
