package lesson2.charsandstrings;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//System.out.println((char)65); //transforms base 10 ascii code for 'A'
		//System.out.println('\u0041'); //prints unicode for 'A'
		//if this doesn't print correctly,
		//change window>preferences>workspace>text encoding
		//to UTF-8
		//System.out.println('\u7ec8');
		System.out.println("\ud835\udd6b, \ud835\udd6b_\ud835\udd6b"); //'\ud835' and '\udd6b' by themselves are  illegal
		//System.out.println(Integer.toHexString((int)'终'));
		//System.out.println(Integer.toHexString(Character.toCodePoint('\ud835','\udd6b')));
		//System.out.println((int)'𝕫');
	}

}
