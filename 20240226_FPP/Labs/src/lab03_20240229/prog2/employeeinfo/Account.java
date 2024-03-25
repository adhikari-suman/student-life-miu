package lab03_20240229.prog2.employeeinfo;

public class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	// Program 1 - 1 Solution
	private AccountType acctType;
	private Employee employee;

	// Program 1 - 1 Solution
	Account(Employee emp, AccountType acctType, double balance) {
		employee = emp;
		this.acctType = acctType;
		this.balance = balance;
	}

	// Program 1 - 1 Solution
	Account(Employee emp, AccountType acctType) {
		this(emp, acctType, DEFAULT_BALANCE);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("Account type: checking\n"));
		sb.append(String.format("Current bal:  %.1f\n", this.getBalance()));
		
		
		return sb.toString();
	}

	// Program 1 - 2 Solution
	public void makeDeposit(double deposit) {
		if (deposit > 0.0) {
			balance += deposit;
		}
	}

	// Program 1 - 2 Solution
	public boolean makeWithdrawal(double amount) {
		// implement
		if(amount == 0.0 || balance - amount < 0.0) {
			return false;
		}
		
		balance -= amount;
		
		return true;
	}

	// Program 1 - 3 Solution
	public AccountType getAcctType() {
		return this.acctType;
	}

	// Program 1 - 3 Solution
	public double getBalance() {
		return this.balance;
	}
}
