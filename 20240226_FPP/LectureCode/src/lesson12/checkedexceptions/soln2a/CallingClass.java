package lesson12.checkedexceptions.soln2a;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/** Case 2a: use try/catch and handle the exception */
public class CallingClass {
	private static final Logger LOG 
	  = Logger.getLogger(
		   CallingClass.class.getPackage().toString());
	void writeInfo() {
		try {
		   FileWriter fw = new FileWriter("MyFile"); 
		} catch(IOException e) {
			LOG.warning("Unable to open file 'MyFile'");
			System.out.println("Error opening file...exiting application");
			System.exit(0);
		}

	}
}
