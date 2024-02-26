package lesson3.objectdemo;

/**
 * The Customer class represents a particular customer,
 * having a name and a checking account.
 * 
 * @author pcorazza
 */
public class Customer {
	private String name;
	private Account checkingAccount;
	
	public Customer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Creates a new checking account and stores it in
	 * the checkingAccount variable.
	 */
	public void createNewAccount() {
		checkingAccount = new Account();
	}
	
	/**
	 * Adds the input value amount to the current balance
	 * of the checkingAccount
	 * 
	 * @param amount - the positive amount to be added to
	 * the checking account balance. Throws an IllegalArgumentException
	 * if input is not positive.
	 */
	public void makeDeposit(double amount) {
		if(amount <= 0) throw new IllegalArgumentException("For deposits, input amount must be a positive number.");
		checkingAccount.updateBalance(amount);
	}
	
	/**
	 * Subtracts the input value amount from the current balance
	 * of the checkingAccount
	 * 
	 * @param amount - the positive amount to be added to
	 * the checking account balance. Throws an IllegalArgumentException
	 * if input is not positive or if this withdrawal will
	 * create a negative balalnce.
	 */
	public void makeWithDrawal(double amount) {
		if(amount <= 0 || amount > checkingAccount.getBalance()) {
			throw new IllegalArgumentException("Withdrawal amount is too large");
		}
		checkingAccount.updateBalance(-amount);
	}
	
	public double checkBalance() {
		return checkingAccount.getBalance();
	}
	
	public String readCheckingAccountId() {
		return checkingAccount.getId();
	}
	public String toString() {
		return "[" + name + ", " + readCheckingAccountId() + "]";
	}
}
