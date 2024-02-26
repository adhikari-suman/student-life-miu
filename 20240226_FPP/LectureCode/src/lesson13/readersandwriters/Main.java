package lesson13.readersandwriters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		//m.inputStreamReader();
		//m.fileReader();
		//m.outputStreamWriter();
		m.printWriter();
	}

	public void inputStreamReader() {
		try {
			InputStreamReader is = new InputStreamReader(System.in);
			//System.out.println(is.getEncoding());
			BufferedReader reader = new BufferedReader(is);
			System.out.print("Type something: ");
			System.out.println("InputStreamReader:  " + reader.readLine());
			is.close();
			reader.close();
			System.out.println();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void fileReader() {
		// uses a FileReader
		try {
			FileReader reader = new FileReader("text.txt");
			BufferedReader bufreader = new BufferedReader(reader);
			String line = null;
			System.out.println("FileReader:");
			while ((line = bufreader.readLine()) != null) {
				System.out.println("  " + line);
			}
			reader.close();
			bufreader.close();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// uses a Scanner
		try {
			Scanner sc = new Scanner(new File("text.txt"));
			String line = null;
			System.out.println("Scanner:");
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				System.out.println("  " + line);
			}
			sc.close();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void outputStreamWriter() {
		Writer os = new OutputStreamWriter(System.out);
		PrintWriter writer = new PrintWriter(os);
		writer.println("OutputStreamWriter:\n" + 
		    "  Output to console with chinese: 你");
		writer.close();
		System.out.println();
	}

	public void printWriter() {
		try {
			PrintWriter writer = 
					new PrintWriter("text3.txt");	
			writer.printf("PrintWriter:\n" + "  Output this character %c to %s", 
					'你', "file");		
			writer.close();		
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}	
	}

}
