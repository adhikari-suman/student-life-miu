package lab04_20240302.prog7.employeeinfo;

abstract public class Account implements Comparable<Account> {// implements Comparable<Account> {
	private Employee emp;
	private double balance;

//	@Override
//	public int compareTo(Account a) {
//		//implement
//	}

	Account(Employee e, double startBalance) {
		emp = e;
		balance = startBalance;

	}

	Account(Employee e) {
		this(e, 0.0);
	}

	abstract public AccountType getAcctType();

	void makeDeposit(double amount) {
		balance += amount;
	}

	boolean makeWithdrawal(double amount) {
		if (amount > balance) {
			return false;
		}
		balance -= amount;
		return true;
	}

	double getBalance() {
		return balance;
	}

	/** used by subclasses only */
	void setBalance(double bal) {
		balance = bal;
	}

	void updateBalance() {
		// by default do nothing
	}

	public Employee getEmp() {
		return emp;
	}

	private String newline = System.getProperty("line.separator");

	public String toString() {
		String ret = "Account type: " + getAcctType().toString().toLowerCase() + newline + "Current bal:  " + balance;
		return ret;
	}

	@Override
	public int compareTo(Account a) {
		// always compare from this/my perspective
		// Double.valueOf(a.balance).compareTo(Double.valueOf(balance)) would be wrong
		// think in terms of my value, I am greater
		return Double.valueOf(balance).compareTo(Double.valueOf(a.balance));

		// problem here with below lines is 0 is not considered ever
		// hence control over precision is transferred to wrapper class for implementation
		// DRY
//		double difference = this.balance - a.balance;

//		if(difference <0 ) {
//			// floor(-0.8) = -1, ceil(0.8) = 0
//			return (int)Math.floor(difference);  
//		} else {
//			// floor(0.8) = 0, ceil(0.8) = 1
//			return (int)Math.ceil(difference);
//		}

	}

}
