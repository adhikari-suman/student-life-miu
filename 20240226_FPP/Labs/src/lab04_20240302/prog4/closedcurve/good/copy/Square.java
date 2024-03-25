package lab04_20240302.prog4.closedcurve.good.copy;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}
	
	@Override
	public int getNumberOfSides() {
		return 4;
	}
	@Override
	public double computePerimeter() {
		// TODO Auto-generated method stub
		return 4 * side;
	}


}
