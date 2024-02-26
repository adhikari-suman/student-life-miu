package lesson2.charsandstrings;

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
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Provides a variety of examples of reading and writing characters,
 * working with unicode and character sets.
 * 
 * @author pcorazza
 *
 */
public class Test {

	static final String PATH = System.getProperty("user.dir") + "\\lesson2\\charsandstrings\\";
	public static void main(String[] args) {
		System.out.println("Default Charset=" + Charset.defaultCharset());
		//it is possible to change the character set
		Charset utf16 = Charset.forName("UTF-16BE");
		Charset utf8 = Charset.forName("UTF-8");
		Charset isolatin = Charset.forName("ISO-8859-1");
		
		String abc = "ABC";
		byte[] asUtf16 = abc.getBytes(utf16);
		byte[] defaultEnc = abc.getBytes();
		byte[] asIsolatin = abc.getBytes(isolatin);
		byte[] asUtf8 = abc.getBytes(utf8);
		
		printArray(asUtf16);
		printArray(defaultEnc);
		printArray(asIsolatin);
		printArray(asUtf8);
		
		
		String chinese = "终"; 
		char[] charArray = chinese.toCharArray();
		asUtf16 = chinese.getBytes(utf16);
		defaultEnc = chinese.getBytes();
		asIsolatin = chinese.getBytes(isolatin);
		asUtf8 = chinese.getBytes(utf8);
		String codepoint = Integer.toHexString(Character.codePointAt(charArray,0));
		String z = "\ud835\udd6b";
		System.out.println(z);
		System.out.println(Integer.toHexString(z.charAt(0)));
		System.out.println(Integer.toHexString(z.charAt(1)));
		printArray(asUtf16);
		printArray(defaultEnc);
		printArray(asIsolatin);
		printArray(asUtf8);
		System.out.println(codepoint);
		
		String newAbc = new String(defaultEnc);
		System.out.println(newAbc);
		System.out.println('\u7ec8');
		
		//testRead2();
		//test4();
		
	}
	
	static void printArray(byte[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void testRead2() {
		try {
			FileReader reader = new FileReader(PATH+"text.txt");
			BufferedReader bufreader = new BufferedReader(reader);
			String line = null;
			while( (line = bufreader.readLine()) != null){
				System.out.println(line);
			}
			bufreader.close();
			reader.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		try {
			Scanner sc = new Scanner(new File(PATH + "text.txt"));			
			String line = null;
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				System.out.println(line);
			}
			sc.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		} 

	}
	static void test4() {
		try {
			PrintWriter writer = new PrintWriter(PATH + "text3.txt");		
			writer.printf("output to %s ", "file");			
			writer.close();		
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	static void test3() {
		try {
			OutputStream stream1 = System.out;
			OutputStream stream2 = new FileOutputStream("text2.txt");
			PrintWriter writer1 = new PrintWriter(new OutputStreamWriter(stream1));
			PrintWriter writer2 = new PrintWriter(new OutputStreamWriter(stream2));
			writer1.println("output to console");
			writer2.println("output to file");
			writer1.close();
			writer2.close();
			stream1.close();
			stream2.close();		
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	static void testRead() {
		try {
			InputStream stream1 = System.in;
			InputStream stream2 = new FileInputStream("text.txt");
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(stream1));
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(stream2));
			System.out.println(reader2.readLine());
			System.out.print("Type something: ");
			System.out.println(reader1.readLine());
			reader1.close();
			reader2.close();
			stream1.close();
			stream2.close();
			
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void test() {
		String \u0041 = "A";
		System.out.println(\u0041);
		System.out.println((int)'A');
		String s = "1234";
		Charset utf16 = Charset.forName("UTF-16BE");
		Charset utf8 = Charset.forName("UTF-8");
		Charset isolatin = Charset.forName("ISO-8859-1");
		byte[] bytes = s.getBytes(utf16);
		String out = new String(bytes,utf16);
		System.out.println(Arrays.toString(bytes));
		System.out.println(out);
	}

}
