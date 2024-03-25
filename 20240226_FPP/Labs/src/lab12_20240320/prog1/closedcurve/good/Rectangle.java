package lab12_20240320.prog1.closedcurve.good;

public class Rectangle extends ClosedCurve {

	private double width;
	private double length;

	public Rectangle(double width, double length) throws IllegalClosedCurveException {

		if (width <= 0 || length <= 0) {
			throw new IllegalTriangleException("An IllegalClosedCurveException was thrown in a Rectangle instance");
		}

		this.length = length;
		this.width = width;
	}

	double computeArea() {
		return width * length;
	}

}
