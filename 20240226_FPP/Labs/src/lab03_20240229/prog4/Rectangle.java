package lab03_20240229.prog4;

public class Rectangle {
	private double length;
	private double width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}
	
	public double computeArea() {
		return  width * length;
	}

}
