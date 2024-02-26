package lesson13.exercise_1_old;
import static lesson13.exercise_1_old.hidden.Setup.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class Main {
	public static final String FILE = System.getProperty("user.dir") + "\\src\\lesson13\\exercise_1\\text.txt";
	public static void main(String[] args) {
		setup();
		try {
			printFileToConsole();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printFileToConsole() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(FILE));
		System.out.println(reader.readLine());
		reader.close();
	}

}
