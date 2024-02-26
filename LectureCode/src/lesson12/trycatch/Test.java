package lesson12.trycatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		try {
//			FileReader r = new FileReader("test.txt");
			FileWriter w = new FileWriter("testW.txt");
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("io exception");
		}
	}

}
