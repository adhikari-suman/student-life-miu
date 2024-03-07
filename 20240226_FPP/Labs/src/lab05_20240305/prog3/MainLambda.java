package lab05_20240305.prog3;

import java.util.Arrays;
import java.util.Comparator;

public class MainLambda {

	public static void main(String[] args) {
		// Arrange
		StringSort ss = new StringSort((s1, s2) -> s1.length() - s2.length());

		// or
//		StringSort ss = new StringSort((s1, s2) -> {
//			return s1.length() - s2.length();
//		});
		
		// or
//		StringSort ss = new StringSort((String s1, String s2) -> {
//			return s1.length() - s2.length();
//		});

		var strArr = new String[] { "Hello", "Hola", "Nino", "La mujer", "El es un hombre" };

		// Act
		ss.stringSort(strArr);

		// Assert
		System.out.println("Array: " + Arrays.toString(strArr));

	}

}
