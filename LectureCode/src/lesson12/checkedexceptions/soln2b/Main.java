package lesson12.checkedexceptions.soln2b;

import java.io.IOException;
import java.util.logging.Logger;


public class Main {
	private static final Logger LOG 
	  = Logger.getLogger(
		   Main.class.getPackage().toString());
	public static void main(String[] args) {
		
		CallingClass c = new CallingClass();
		try {
			c.writeInfo();
		} catch(IOException e) {
			LOG.warning("File cannot be opened...current state of Main: . . .");
			System.out.println("File can't be opened..exiting");
			System.exit(0);
		}

	}

}
