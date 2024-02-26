package lesson4.java8interface_oldway;

import java.time.LocalDate;
import java.util.List;

public interface ShoppingCart {
	String getName();
	List<Item> getItems();
	LocalDate getDateOfPurchase();
	void addItem(Item item);
	double getCost();
	String printReceipt();
}
