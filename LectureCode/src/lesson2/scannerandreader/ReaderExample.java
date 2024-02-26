package lesson2.scannerandreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderExample {

	public static void main(String[] args) {
		BufferedReader buf = null;
		String input = null;
		buf = new BufferedReader(new
  			 InputStreamReader(System.in));
		System.out.print("Type your name: ");
		try {
			input = buf.readLine();
			System.out.println("You wrote " + input);
			buf.close();
		} catch(IOException e) {
			System.out.println("An exception has been thrown " 
		         + e.getMessage());
		}


	}

}
