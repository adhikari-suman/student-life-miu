package lab05_20240305.prog3;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// Arrange
		StringSort ss = new StringSort(new StringLengthComparator());

		var strArr = new String[] { "Hello", "Hola", "Nino", "La mujer", "El es un hombre" };

		
		// Act
		ss.stringSort(strArr);
		
		
		// Assert
		System.out.println("Array: "+Arrays.toString(strArr));
		
	}

}
