package lesson4.accesstypebadsoln;

public class Test {
	
	public static void main(String[] args) {

		ClosedCurve[] objects = {new Triangle(4,5,6),
								 new Square(3),
								 new Circle(3)};
		//compute areas
		for(ClosedCurve cc : objects) {
			System.out.println("The area of this " + name(cc) + " is " + cc.computeArea());
			
		}
    
	}
	
	private static String name(ClosedCurve c) {
		if(c instanceof Triangle) return "Triangle";
		if(c instanceof Square) return "Square";
		if(c instanceof Circle) return "Circle";
		return null;
	}

}