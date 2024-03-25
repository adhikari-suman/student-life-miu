package lab05_20240305.prog3;

import java.util.*;

public class MainAnonymous {

	public static void main(String[] args) {
		// Arrange
		StringSort ss = new StringSort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return s1.length() - s2.length();
			}
			
		});

		var strArr = new String[] { "Hello", "Hola", "Nino", "La mujer", "El es un hombre" };

		// Act
		ss.stringSort(strArr);

		// Assert
		System.out.println("Array: " + Arrays.toString(strArr));

	}

}
