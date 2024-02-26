package lesson2.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lesson2.regex.consolemanage.*;

//Note: Originally designed to be used with a Console. Console not available in an IDE,
//so it has been replaced by a TextDevice
public class TestHarness  {

	public static void main(String[] args) {
		try {
			TextDevice console = TextDevices.defaultTextDevice();
			if (console == null) {
				System.err.println("No console.");
				System.exit(1);
			}
			while (true) {
	            System.out.println("%nEnter your regex: ");
				Pattern pattern = Pattern.compile(console
						.readLine());
	
				System.out.println("Enter input string to search: ");
				Matcher matcher = pattern.matcher(console
						.readLine());
	
				boolean found = false;
				while (matcher.find()) {
					System.out.printf("I found the text" + " \"%s\" starting at "
							+ "index %d and ending at index %d.%n",
							matcher.group(), matcher.start(), matcher.end());
					
					found = true;
				}
				if (!found) {
					System.out.println("No match found.%n");
				}
			}
		} catch(ConsoleException e) {
			e.printStackTrace();
		}
		
	}

	
	

}
