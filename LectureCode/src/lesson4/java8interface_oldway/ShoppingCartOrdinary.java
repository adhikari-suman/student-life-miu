package lesson4.java8interface_oldway;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartOrdinary implements ShoppingCart {
	private String name;
	private List<Item> items = new ArrayList<>();;
	private LocalDate dateOfPurchase;
	public ShoppingCartOrdinary(String name, LocalDate d) {
		this.name = name;
		dateOfPurchase = d;
	}
	public ShoppingCartOrdinary(String name, List<Item> items, 
		LocalDate d) {
		this(name, d);
		this.items = items;	
	}
	public void addItem(Item item) {
		items.add(item);
	}
	public String getName() { 
		return name;
	}
	public List<Item> getItems() {
		return items;
	}
	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}
	@Override
	public String printReceipt() {
		String ret =
			"Customer: " + getName() + "\n" 
			   + getItems() + "\n" 
			   + "Total: " + Util.formatDouble(getCost()) + "\n";
		return ret;
	}
	@Override
	public double getCost() {
		return Util.computeBaseCost(getItems());
	}
	
}
