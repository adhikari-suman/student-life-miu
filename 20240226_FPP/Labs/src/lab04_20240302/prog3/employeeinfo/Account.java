package lab04_20240302.prog3.employeeinfo;

public abstract class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private Employee employee;


	Account(Employee emp, double balance) {
		employee = emp;
		this.balance = balance;
	}


	Account(Employee emp) {
		this(emp, DEFAULT_BALANCE);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("Account type: checking\n"));
		sb.append(String.format("Current bal:  %.1f\n", this.getBalance()));
		
		
		return sb.toString();
	}

	public void makeDeposit(double deposit) {
		if (deposit > 0.0) {
			balance += deposit;
		}
	}

	public boolean makeWithdrawal(double amount) {
		// implement
		if(amount == 0.0 || balance - amount < 0.0) {
			return false;
		}
		
		balance -= amount;
		
		return true;
	}

	public abstract AccountType getAcctType();

	public double getBalance() {
		return this.balance;
	}
}
