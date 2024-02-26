package lesson4.badrandom;


public class BadRandom {
	
	public static void main(String[] args){		
		for(int i = 0; i < 1000; ++i){
			//randomly pick the length of the ClosedCurve array
			int len = RandomNumbers.getRandomInt(1,100);
				ClosedCurve[] cc = new ClosedCurve[len];
				for(int j = 0; j < len; ++j){
					//randomly select the next closed curve to place in array
					cc[j] = pickNextClosedCurve();
				}
				for(int j = 0; j < len; ++j) {
					System.out.println(cc[j].computeArea());
				}
		}
	}
	static ClosedCurve pickNextClosedCurve() {
		int type = RandomNumbers.getRandomInt(1,3);
		switch(type) {
			case 1:
				return new Triangle(RandomNumbers.getRandomInt(1,100),
									RandomNumbers.getRandomInt(1,100),
									RandomNumbers.getRandomInt(1,100));				
			case 2:
				return new Square(RandomNumbers.getRandomInt(1,100));			
			case 3:
				return new Circle(RandomNumbers.getRandomInt(1,100));			
			default:
				return null;
		}
	}

}

abstract class ClosedCurve {
	
	double computeArea(){
		return 0.0;
	}
} 


class Triangle extends ClosedCurve {
	
	Triangle(double s1, double s2, double s3){}
}

class Square extends ClosedCurve{
	
	Square(double s){}
}

class Circle extends ClosedCurve {
	Circle(double rad){}
	
}