package lab04_20240302.prog3.employeeinfo;

import java.util.Date;
import java.util.GregorianCalendar;

import lab04_20240302.prog3.MyStringList;

import java.time.LocalDate;

public class Employee {

	private AccountList accounts;
	private String name;
	private LocalDate hireDate;

	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
		this.name = name;
		accounts = new AccountList();
		/*
		 * update, using LocalDate GregorianCalendar cal = new
		 * GregorianCalendar(yearOfHire,monthOfHire-1,dayOfHire); hireDate =
		 * cal.getTime();
		 */
	}

	public void createNewChecking(double startAmount) {
		Account a = new CheckingAccount(this, startAmount);
		accounts.add(a);
	}

	public void createNewSavings(double startAmount) {
		Account s = new SavingsAccount(this, startAmount);
		accounts.add(s);

	}

	public void createNewRetirement(double startAmount) {
		Account r = new RetirementAccount(this, startAmount);
		accounts.add(r);

	}

	public String getFormattedAcctInfo() {
		StringBuilder sb = new StringBuilder();

		/**
		 * ACCOUNT INFO FOR Jim Daley: Account type: checking Current bal: 10500.0
		 * Account type: savings Current bal: 1000.0 Account type: retirement Current
		 * bal: 9300.0
		 */

		sb.append(String.format("ACCOUNT INFO FOR %s:\n", this.name));

		// could override toString() in getFormattedAccountInfo as well for this
		sb.append(accounts.getFormattedAccountInfo());

		sb.append("\n\n");

		return sb.toString();
	}

	public void deposit(int accountIndex, double amt) {
		if (accountIndex < 0 || accounts.size() <= accountIndex) {
			return;
		}

		accounts.get(accountIndex).makeDeposit(amt);
	}

	public boolean withdraw(int accountIndex, double amt) {
		if (accountIndex < 0 || accounts.size() <= accountIndex) {
			return false;
		}

		Account a = accounts.get(accountIndex);

		if (a.getBalance() - amt < 0) {
			System.out.println("Insufficient funds");
			return false;
		}

		return a.makeWithdrawal(amt);
	}

	public String getName() {
		return this.name;
	}

	public LocalDate getHireDate() {
		return this.hireDate;
	}
	
	public String[] getNamesOfAccounts() {
		MyStringList mList = new MyStringList();
		
		for(int i = 0;i<accounts.size();i++) {
			mList.add(accounts.get(i).getAcctType().toString().toLowerCase());
		}
		
		// For some reason,MyStringList lacked the implementation for 
		// returning only the list of actual data considering the size
		// so simpler approach was used
		String[] names = new String[mList.size()];
		
		for(int i=0;i<names.length;i++) {
			names[i] = mList.get(i);
		}
		
		return names;
	}

}
