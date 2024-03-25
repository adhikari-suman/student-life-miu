package lab04_20240302.prog5.closedcurve.good;

public interface Polygon {

	// returns in an array all sides of the polygon
	// example: For a rectangle,
	// return would be [width, width,
	// length, length]
	public double[] getArrayOfSides();

	// returns the sum of the values in arr
	public static double sum(double[] arr) {
		int sum = 0;

		for (double n : arr) {
			sum += n;
		}

		return sum;

	}

	// returns the perimeter of the polygon
	public default double computePerimeter() {
		return sum(getArrayOfSides());
	}
}
