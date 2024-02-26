package lesson2.exercise_4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//use a Scanner to ask for user's name
		//output the number of occurrences of 'e' in the name
		Scanner sc = new Scanner(System.in);
		System.out.println("Your name?");
		String name = sc.nextLine();
		sc.close();
		int count = 0;
		for(int i = 0; i < name.length(); ++i) {
			if(name.charAt(i) == 'e' || name.charAt(i) == 'E') {
				++count;
			}
		}
		System.out.println("Number of occurrences of 'e/E': " + count);

	}

}
