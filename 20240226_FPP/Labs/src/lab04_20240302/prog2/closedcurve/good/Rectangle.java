package lab04_20240302.prog2.closedcurve.good;

public class Rectangle extends ClosedCurve {
	private double length, width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}


	@Override
	double computeArea() {
		return length * width;
	}

}
