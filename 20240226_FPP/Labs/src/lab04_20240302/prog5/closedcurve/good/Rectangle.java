package lab04_20240302.prog5.closedcurve.good;

public class Rectangle extends ClosedCurve implements Polygon {
	private double length, width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	double computeArea() {
		return length * width;
	}

	@Override
	public double[] getArrayOfSides() {
		return new double[] { width, width, length, length };
	}

	@Override
	public double computePerimeter() {
		return 2 * (length + width);
	}

}
