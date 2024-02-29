package lab03_20240228.prog5;

import java.util.Scanner;
public class Prog5 {

	public static void main(String[] args) {
		// 1. Create Scanner object with InputStream as input
		Scanner sc = new Scanner(System.in);

		// 2. Ask for input
		System.out.print("Enter a string: ");
		String str = sc.nextLine();
		
		// 3. Output the reverse string, no new String created or used
		for(int i=str.length()-1;i>=0;i--) {
			System.out.printf("%c", str.charAt(i));
		}
		
		// 4. Printing a new line just for the batch file
		System.out.println();
	}

}
