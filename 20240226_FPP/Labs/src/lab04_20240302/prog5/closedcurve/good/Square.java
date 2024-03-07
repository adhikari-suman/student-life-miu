package lab04_20240302.prog5.closedcurve.good;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}
	
	@Override
	public double computePerimeter() {
		// TODO Auto-generated method stub
		return 4 * side;
	}
	@Override
	public double[] getArrayOfSides() {
		return new double[] {side, side, side, side};
	}


}
