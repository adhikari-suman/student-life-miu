package lab04_20240302.prog3.employeeinfo;

public class RetirementAccount extends Account {
	private static final double PENALTY_RATE_ON_WITHDRAWL = 2;

	RetirementAccount(Employee emp, double balance) {
		super(emp, balance);
	}

	@Override
	public AccountType getAcctType() {
		return AccountType.RETIREMENT;
	}

	@Override
	public boolean makeWithdrawal(double amount) {
		double baseBalance = super.getBalance();

		double penaltyAmt = baseBalance * PENALTY_RATE_ON_WITHDRAWL / 100;

		return super.makeWithdrawal(amount + penaltyAmt);
	}

}
