package standard_exam_20240406.prob2;

import java.util.*;
public class Employee {

	private String name;

	private List<Account> accounts;

	public Employee(String name, List<Account> accounts) {
		this.name = name;
		this.accounts = accounts;
	}

	public Employee(String name) {
		this(name, new ArrayList<>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void addAccount(Account acct) {
		accounts.add(acct);
	}

	public double computeUpdatedBalanceSum() {
		//implement
		double total = 0;

		for (var acct: accounts){
			total += acct.computeUpdatedBalance();
		}

		return total;
	}
}
