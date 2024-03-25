package lab04_20240302.prog4.closedcurve.good;

public class Test2 {

	public static void main(String[] args) {

		Polygon[] objects = { new Square(3), new Triangle(4, 5, 6), new Rectangle(3, 4),

		};
		// compute areas
		for (Polygon p : objects) {
			String cName = p.getClass().getSimpleName();

			StringBuilder sb = new StringBuilder("");
			sb.append(String.format("For this %s\n", cName));
			sb.append(String.format("  Number of sides = %d\n", p.getNumberOfSides()));
			sb.append(String.format("  Perimeter = %.1f", p.computePerimeter()));

			System.out.println(sb);
		}

	}

}