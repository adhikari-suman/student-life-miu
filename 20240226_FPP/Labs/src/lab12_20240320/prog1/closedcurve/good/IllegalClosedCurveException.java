package lab12_20240320.prog1.closedcurve.good;

public class IllegalClosedCurveException extends Exception {
	
	private static final String DEFAULT_MSG = "Not a Closed Curve!";
	
	public  IllegalClosedCurveException() {
		super(DEFAULT_MSG);
	}

	public IllegalClosedCurveException(String message) {
		super(message);
	}
}
