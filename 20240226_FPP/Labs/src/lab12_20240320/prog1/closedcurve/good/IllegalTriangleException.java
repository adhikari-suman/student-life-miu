package lab12_20240320.prog1.closedcurve.good;

public class IllegalTriangleException extends IllegalClosedCurveException {

	private static final String DEFAULT_MSG = "Not a Triangle!";

	public IllegalTriangleException() {
		super(DEFAULT_MSG);
	}

	public IllegalTriangleException(String message) {
		super(message);
	}

}
