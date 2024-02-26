package lesson2.staticdemo;

//import static lesson2.staticdemo.RandomNumbers.*;
import java.util.Scanner;

public class StringGame {
	public static void main(String[] args) {
		//all test strings must have length >= 4
		String[] testStrings =
		{"inventor", "indistinguishable", "semblance", "registered", 
				"ambidextrous", "advocate", "fantastic", "frontispiece", "intermittent"};
		String answer = "y";
		Scanner sc = new Scanner(System.in);
		while(answer.equals("y") || answer.equals("Y")){
			int randIndex = RandomNumbers.getRandomInt(0, testStrings.length-1);
			String nextStr = testStrings[randIndex];
			String nextScramble = scrambleString(nextStr);
			nextRoundInGame(nextStr, nextScramble);
			System.out.println();
			System.out.print("Play again? (Y or N) ");
			answer = sc.next();
		}
		System.out.println("Better luck next time!");
		sc.close();
	}
	/** Move first two letters to back, last two letters
	 * to front
	 */
	static String scrambleString(String input){
		int len = input.length();
		String front = input.substring(0,2);
		String middle = input.substring(2,len-2);
		String end = input.substring(len-2, len);
		return end+middle+front;
		
	}
	static void nextRoundInGame(String origString, String scrambledString){
		Scanner sc = new Scanner(System.in);
		System.out.println("Now try to unscramble this word: "+scrambledString);
		System.out.print("Your answer: ");
		
		String answer = sc.next();
		System.out.println();
		if(answer.equals(origString)) {
			System.out.println("Correct!");
		}
		else{
			System.out.println("Incorrect!");
		}	
	}
}
