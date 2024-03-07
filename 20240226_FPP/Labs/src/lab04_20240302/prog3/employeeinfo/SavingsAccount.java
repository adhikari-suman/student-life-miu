package lab04_20240302.prog3.employeeinfo;

public class SavingsAccount extends Account {

	private static final double MONTHLY_INTEREST_RATE = 0.25;

	SavingsAccount(Employee emp, double balance) {
		super(emp, balance);
	}

	@Override
	public AccountType getAcctType() {
		return AccountType.SAVINGS;
	}

	@Override
	public double getBalance() {
		double baseBalance = super.getBalance();
		double interest = (MONTHLY_INTEREST_RATE / 100) * baseBalance;
		return baseBalance + interest;
	}
}
