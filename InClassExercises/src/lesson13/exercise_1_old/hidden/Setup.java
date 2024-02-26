package lesson13.exercise_1_old.hidden;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import lesson13.exercise_1_old.*;
public class Setup {

	public static void setup() {
		try {
			OutputStream stream = 
				new FileOutputStream(Main.FILE);
			PrintWriter writer = new PrintWriter(
					new OutputStreamWriter(stream, StandardCharsets.ISO_8859_1));
			writer.println("This is an extended ASCII character: Ó");
			writer.close();
			stream.close();		
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
