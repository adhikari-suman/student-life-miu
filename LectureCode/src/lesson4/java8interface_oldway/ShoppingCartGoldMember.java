package lesson4.java8interface_oldway;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartGoldMember implements ShoppingCart {
	private String name;
	private List<Item> items = new ArrayList<>();
	private LocalDate dateOfPurchase;
	private double discount;
	public ShoppingCartGoldMember(String name, 
		LocalDate d, double discount) {
		this.name = name;
		dateOfPurchase = d;
		this.discount = discount;
	}
	public ShoppingCartGoldMember(String name, List<Item> items, 
		LocalDate d, double discount) {
		this(name, d, discount);	
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
	
	public double getDiscount() {
		return discount;
	}
	@Override
	public String printReceipt() {
		String ret =
			"Customer: " + getName() + "\n" +
			  getItems() + "\n" +
			  "Total: " + Util.formatDouble(getCost()) + "\n";
		if(getDiscount() > 0.0) {
			 ret += "  Applied a " + (int)(100 * getDiscount()) + "% discount.";	
		}
		return ret;
	}
	@Override
	public double getCost() {
		return (1 - getDiscount()) * Util.computeBaseCost(getItems());
	}
}
