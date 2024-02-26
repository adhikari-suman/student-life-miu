package lesson13.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileDemo {


	public static void main(String[] args) {
		new FileDemo();
	}

	public FileDemo() {
		//working directory
		System.out.println("JVM will look for files in here: ");
		System.out.println(System.getProperty("user.dir"));
		
		try {
			//scanText();
			readText();
			//writeText();
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}		
	}
	void scanText() throws IOException {
		File f = new File("word_test.txt");
		//Hack to read entire file into a single string
		//String delim = ""+(char)0;
		//Scanner s = new Scanner(f,delim);
		Scanner s = new Scanner(f);
		String line = null;
		
		String word = null;
		try {
			
			while( (word = s.next()) != null){
				System.out.println(word);
			}
		}
		catch(NoSuchElementException e){
		}
		s.close();
	}
	void readText() throws IOException {
		FileReader fr = new FileReader("word_test.txt");
		BufferedReader reader = new BufferedReader(fr);
		String firstLine = reader.readLine();
		/*
		 * To read many lines, loop like this:
		 * String line = null;
		 * while((line = reader.readLine()) != null) {
		 * 	//do something with the line
		 * }
		 * 
		 */
		System.out.println("\nRead using BufferedReader: \n" + "  " + firstLine);
		reader.close();
		
		
	}
	void writeText() throws IOException {
		FileWriter fw = new FileWriter("word_test.txt");
		PrintWriter writer = new PrintWriter(fw);
		writer.write("new values");
		fw.close();
		writer.close();
	}
}
