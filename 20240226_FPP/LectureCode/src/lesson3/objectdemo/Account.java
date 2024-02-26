package lesson3.objectdemo;

/**
 * The Account class represents a particular bank account, having a unique
 * id, and having a balance, which can be updated. Unique id is created
 * during instantiation by obtaining a random number in the range 1000...9999
 * @author pcorazza
 *
 */
public class Account {
	private static final int ID_LOWER = 1000;
	private static final int ID_UPPER = 9999;
	private String id;
	public Account() {
		id = generateId();
	}
	private double balance;
	
	public void updateBalance(double amount) {
		balance += amount;
	}
	public double getBalance() {
		return balance;
	}
	
	public String getId() {
		return id;
	}
	
	private String generateId() {
		//in actual practice, read from a database or
		//external data source
		return "" + RandomNumbers.getRandomInt(ID_LOWER,ID_UPPER);
	}
	
	public String toString() {
		return id + ":" + balance;
	}
}
