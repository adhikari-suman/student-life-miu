package lesson2.switchdemo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		stringSample();
		//intSample();
		
	}
	
	public static void stringSample() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type one of the strings 'Apple', 'Cherry', 'Papaya' ");
		String val = sc.next();
		sc.close();
		System.out.println();
		
		switch(val) {
			case "Apple": 
				System.out.println("'Apple' starts with 'A'.");
				break;
			case "Cherry": 
				System.out.println("'Cherry' starts with 'C'");
				break;
			case "Papaya": System.out.println("'Papaya' starts with 'P'");
				break;
			default:
				System.out.println("Bad selection.");
		}	
	}
	public static void intSample() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Pick an integer in the range 1..9 ");
		int val = sc.nextInt();
		System.out.println();
		switch(val) {
			case 2:
			case 4:
			case 6:
			case 8: 
				System.out.println("You chose an even number.");
				break;
			default:
				System.out.println("You chose an odd number.");
		}	

	}
	
	

}
