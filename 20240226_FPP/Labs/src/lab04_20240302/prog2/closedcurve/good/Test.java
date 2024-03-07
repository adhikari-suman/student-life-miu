package lab04_20240302.prog2.closedcurve.good;

public class Test {

	public static void main(String[] args) {

		ClosedCurve[] objects = {new Triangle(4,5,6),
								 new Square(3),
								 new Rectangle(3, 7),
								 new Circle(3),
								 
		};
		//compute areas
		for(ClosedCurve cc : objects) {
			
			String cName = cc.getClass().getSimpleName();
			
			System.out.printf("The area of this %s is %f\n", cName, cc.computeArea());
			
		}
    
	}

}