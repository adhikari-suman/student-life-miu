package lab03_20240229.prog2.employeeinfo;

import java.time.LocalDate;

public class Employee {

	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;

	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
		this.name = name;
		/*
		 * update, using LocalDate GregorianCalendar cal = new
		 * GregorianCalendar(yearOfHire,monthOfHire-1,dayOfHire); hireDate =
		 * cal.getTime();
		 */
	}

	public void createNewChecking(double startAmount) {
		checkingAcct = new Account(this, AccountType.CHECKING, startAmount);
	}

	public void createNewSavings(double startAmount) {
		savingsAcct = new Account(this, AccountType.SAVINGS, startAmount);

	}

	public void createNewRetirement(double startAmount) {
		retirementAcct = new Account(this, AccountType.RETIREMENT, startAmount);

	}

	public String getFormattedAcctInfo() {
		StringBuilder sb = new StringBuilder();

		/**
		 * ACCOUNT INFO FOR Jim Daley: Account type: checking Current bal: 10500.0
		 * Account type: savings Current bal: 1000.0 Account type: retirement Current
		 * bal: 9300.0
		 */

		sb.append(String.format("ACCOUNT INFO FOR %s:\n", this.name));

		if (checkingAcct != null) {
			sb.append(this.checkingAcct);
		}

		if (savingsAcct != null) {
			sb.append(this.savingsAcct);
		}

		if (retirementAcct != null) {
			sb.append(this.retirementAcct);
		}

		sb.append("\n\n");

		return sb.toString();
	}

	public void deposit(AccountType acctType, double amt) {
		switch (acctType) {
		case CHECKING:
			if (checkingAcct != null)
				checkingAcct.makeDeposit(amt);
			break;

		case SAVINGS:
			if (savingsAcct != null)
				savingsAcct.makeDeposit(amt);
			break;

		case RETIREMENT:
		default:
			if (retirementAcct != null)
				retirementAcct.makeDeposit(amt);
			break;
		}
	}

	public boolean withdraw(AccountType acctType, double amt) {
		switch (acctType) {
		case CHECKING:
			if (checkingAcct != null)
				return checkingAcct.makeWithdrawal(amt);
			

		case SAVINGS:
			if (savingsAcct != null)
				return savingsAcct.makeWithdrawal(amt);
			

		case RETIREMENT:
		default:
			if (retirementAcct != null)
				return retirementAcct.makeWithdrawal(amt);
		}
		return false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public LocalDate getHireDate() {
		return this.hireDate;
	}

}
