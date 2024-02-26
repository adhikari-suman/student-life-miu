package lesson4.java8interface;

public class Util {
	
	//Belongs in a utility class -- could be used 
	//in many scenarios, not just for ShoppingCarts
	public static String formatDouble(double x) {
		return String.format("%.2f", x);
	}
}
