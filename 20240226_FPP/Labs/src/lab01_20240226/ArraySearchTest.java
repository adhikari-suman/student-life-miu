package lab01_20240226;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraySearchTest {

	/**
	 * 1. The target is the first element in the array.
	 */

	@Test
	public void testFirstElementInTheArray() {
		// Arrange
		int[] numbers = { 1, 2, 3, 4, 5, 6 };
		int target = 1;
		int expected = 0;

		// Act
		int index = ArraySearch.search(numbers, target);

		// Assert
		assertEquals(expected, index);
	}

	/**
	 * 2. The target is the last element in the array.
	 */

	@Test
	public void testLastElementInTheArray() {
		// Arrange
		int[] numbers = { 1, 2, 3, 4, 5, 6 };
		int target = 6;
		int expected = 5;

		// Act
		int index = ArraySearch.search(numbers, target);

		// Assert
		assertEquals(expected, index);
	}

	/**
	 * 3. The target is somewhere in the middle.
	 */

	@Test
	public void testMiddleElementInTheArray() {
		// Arrange
		int[] numbers = { 1, 2, 3, 4, 5, 6 };
		int target = 4;
		int expected = 3;

		// Act
		int index = ArraySearch.search(numbers, target);

		// Assert
		assertEquals(expected, index);
	}

	/**
	 * 4. The target element is not in the array.
	 */

	@Test
	public void testElementNotInTheArray() {
		// Arrange
		int[] numbers = { 1, 2, 3, 4, 5, 6 };
		int target = 7;
		int expected = -1;

		// Act
		int index = ArraySearch.search(numbers, target);

		// Assert
		assertEquals(expected, index);
	}

	/**
	 * 5. There is more than one occurrence of the target element and we find the
	 * first occurrence.
	 */

	@Test
	public void testMoreThanOneOccurenceInArray() {
		// Arrange
		int[] numbers = { 1, 2, 3, 4, 5, 5, 6 };
		int target = 5;
		int expected = 4;

		// Act
		int index = ArraySearch.search(numbers, target);

		// Assert
		assertEquals(expected, index);
	}

	/**
	 * 6. The array has only one element and it is not the target.
	 */

	@Test
	public void testElementNotInSingleElementArray() {
		// Arrange
		int[] numbers = { 1 };
		int target = 2;
		int expected = -1;

		// Act
		int index = ArraySearch.search(numbers, target);

		// Assert
		assertTrue(numbers.length == 1);
		assertTrue(expected == index);
	}

	/**
	 * 7. The array has only one element and it is the target.
	 */

	@Test
	public void testElementInSingleElementArray() {
		// Arrange
		int[] numbers = { 1 };
		int target = 1;
		int expected = 0;

		// Act
		int index = ArraySearch.search(numbers, target);

		// Assert
		assertTrue(numbers.length == 1);
		assertTrue(expected == index);
	}

	/**
	 * 8. The array has no elements.
	 */

	@Test
	public void testEmptyArray() {
		// Arrange
		int[] numbers = {};
		int target = 1;
		int expected = -1;

		// Act
		int index = ArraySearch.search(numbers, target);

		// Assert
		assertTrue(numbers.length == 0);
		assertTrue(expected == index);
	}

}
