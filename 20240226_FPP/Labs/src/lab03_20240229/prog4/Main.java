package lab03_20240229.prog4;

public class Main {

	public static void main(String... args) {
		Triangle t = new Triangle(5.0, 10.0);
		Circle c = new Circle(5);
		Rectangle r = new Rectangle(4, 5);

		System.out.printf("Area of Triangle is %.2f\n", t.computeArea());
		System.out.printf("Area of Rectangle is %.2f\n", r.computeArea());
		System.out.printf("Area of Circle is %.2f\n", c.computeArea());
	}
}
