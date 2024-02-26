package lesson4.java8interface;

import java.time.LocalDate;
import java.util.List;

public interface ShoppingCart {
	String getName();
	List<Item> getItems();
	LocalDate getDateOfPurchase();
	void addItem(Item item);
	
	//Utility that belongs with ShoppingCart
	//Should be able to compute base cost even if
	//no instance of ShoppingCart exists - a "price check"
	static double computeBaseCost(List<Item> items) {
		double accum = 0.0;
		for(Item item : items) {
			accum += (item.getPrice() + item.getTax());
		}
		return accum;
	}
	
	
	default double getDiscount() {
		return 0.0;
	}
	
	default String printReceipt() {
		String ret =
			"Customer: " + getName() + "\n" 
			   + getItems() + "\n" 
			   + "Total: " + Util.formatDouble(getCost()) + "\n";
		if(getDiscount() > 0.0) {
			 ret += "  Applied a " + (int)(100*getDiscount()) + "% discount.";	
		}
		return ret;
	}
	default double getCost() {
		return (1 - getDiscount()) * computeBaseCost(getItems());
	}
}
