package lesson1.exercise_2;

import org.junit.Test;

import static org.junit.Assert.*;

import lesson1.exercise_1.MyClass;

public class TestMyClass {
	@Test
	public void testProduct() {
		// Arrange
		var numbers = new int[]{2,4,6};
		int expected = 48;
		
		// Act
		int result = MyClass.product(numbers);
		
		// Assert
		assertEquals(expected, result);
	}
	
	@Test
	public void testProductZero() {
		// Arrange
		var numbers = new int[]{};
		int expected = 0;
		
		// Act
		int result = MyClass.product(numbers);
		
		// Assert
		assertEquals(expected, result);
	}
	
	@Test
	public void testConcatenate() {
		// Arrange
		String[] strings = {"Hello",", ", "World!"};
		String expected = "Hello, World!";
		
		// Act
		String result = MyClass.concatenate(strings);
		
		// Assert
		assertTrue(expected.equals(result));
	}
}
