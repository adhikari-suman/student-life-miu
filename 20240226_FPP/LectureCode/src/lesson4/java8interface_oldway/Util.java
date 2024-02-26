package lesson4.java8interface_oldway;

import java.util.List;

public class Util {
	
	
	public static String formatDouble(double x) {
		return String.format("%.2f", x);
	}
	
	public static double computeBaseCost(List<Item> items) {
		double accum = 0.0;
		for(Item item : items) {
			accum += (item.getPrice() + item.getTax());
		}
		return accum;
	}
}
