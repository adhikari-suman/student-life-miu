package lesson2.exercise_4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//use a Scanner to ask for user's name
		//output the number of occurrences of 'e' in the name
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = scan.nextLine();
		
		int numberOfEs = 0;
		
		for(int i=0;i<name.length();i++) {
			if(name.charAt(i) == 'e') {
				numberOfEs++;
			}
		}
		
		scan.close();
		System.out.printf("Number of e's in %s: %d",  name, numberOfEs);
	}

}
