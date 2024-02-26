package lesson4.accesstype;

public final class Square extends ClosedCurve {
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}


}
