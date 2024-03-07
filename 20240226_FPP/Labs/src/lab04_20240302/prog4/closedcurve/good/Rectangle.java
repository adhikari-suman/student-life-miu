package lab04_20240302.prog4.closedcurve.good;

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
	public int getNumberOfSides() {
		return 4;
	}

	@Override
	public double computePerimeter() {
		return 2 * (length + width);
	}

}
