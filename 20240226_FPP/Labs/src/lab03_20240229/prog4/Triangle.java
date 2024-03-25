package lab03_20240229.prog4;

public class Triangle {
	private double height;
	private double base;

	public Triangle(double height, double base) {
		this.height = height;
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public double getBase() {
		return base;
	}
	
	public double computeArea() {
		return 1/2.0 * base * height;
	}

}
