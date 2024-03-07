package lab03_20240229.prog4;

public class Circle {

	private double radius;

	public Circle( double width) {
		this.radius = width;
	}

	public double computeArea() {
		return  Math.PI * Math.pow(radius,2);
	}

}
