package lesson12.logging;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MyLogTester {
	public static final Level LEVEL = Level.ALL; //FINE INFO WARNING SEVERE
	public static final Logger LOG = Logger.getLogger("lesson12.logging.MyLogTester");
	static {
		setLogLevel(LOG, LEVEL);
	}
	public static void main(String[] args) {
		LOG.severe("Severe message");
		LOG.warning("Warning message");
		LOG.info("info message");
		LOG.fine("Debug message");
	}
	
	private static void setLogLevel(Logger logger, Level lev) {
		if(logger == null) return;
		logger.setLevel(lev);
		Handler[] handlers = logger.getHandlers();
		for(int i = 0; i < handlers.length; ++i) {
			handlers[i].setLevel(lev);
		}
		setLogLevel(logger.getParent(), lev);	
	}
}
