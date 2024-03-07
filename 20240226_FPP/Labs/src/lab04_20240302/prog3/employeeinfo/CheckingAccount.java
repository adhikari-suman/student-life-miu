package lab04_20240302.prog3.employeeinfo;

public class CheckingAccount extends Account {
	private static final double MONTHLY_SERVICE_CHARGE = 5;

	CheckingAccount(Employee emp, double balance) {
		super(emp, balance);
	}

	@Override
	public AccountType getAcctType() {
		return AccountType.CHECKING;
	}
	
	@Override
	public double getBalance() {
		double baseBalance = super.getBalance();
		
		return baseBalance - MONTHLY_SERVICE_CHARGE;
	}

}
