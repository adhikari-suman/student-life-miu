package lesson12.checkedexceptions.soln2b;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/** Case 2b: use try/catch and partially handle exception, then re-throw */
public class CallingClass {
	private static final Logger LOG 
	  = Logger.getLogger(
		   CallingClass.class.getPackage().toString());
	void writeInfo() throws IOException {
		try {
		   FileWriter fw = new FileWriter("MyFile"); 
		} catch(IOException e) {
			LOG.warning("Unable to open file 'MyFile'");
			System.out.println("Error opening file...exiting application");
			throw e;
		}

	}
}
