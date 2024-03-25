package lab02_20240227.prog3;

public class Prog3 {
	public static void main(String... args) {
		// 1. create float variables
		float a = 1.27f, b = 3.881f, c = 9.6f;
		
		// 2. Output the sum of the floats as an integer, obtained by casting the sum to type int
		int sum = (int)(a+b+c);
		System.out.println("Sum: "+sum);
		
		// 3. Output the sum of the floats as an integer, obtained by rounding the sum to the nearest
		// integer, using the Math.round function
		int roundedSum = Math.round(a+b+c);
		System.out.println("Sum(rounded): "+roundedSum);
	}
}
