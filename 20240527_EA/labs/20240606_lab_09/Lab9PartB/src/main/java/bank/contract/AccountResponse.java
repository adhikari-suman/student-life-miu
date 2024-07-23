package bank.contract;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class AccountResponse {

	long accountNumber;

	Collection<AccountEntryResponse> entryList;

	CustomerResponse customer;

	public AccountResponse() {
		entryList = new ArrayList<>();
	}

	public AccountResponse(long accountnr){
		this.accountNumber = accountnr;
		entryList = new ArrayList<>();
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance=0;
		for (AccountEntryResponse entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount){
		AccountEntryResponse entry = new AccountEntryResponse(new Date(), amount, "deposit", "", "");
		entryList.add(entry);
	}

	public void withdraw(double amount){
		AccountEntryResponse entry = new AccountEntryResponse(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);	
	}

	private void addEntry(AccountEntryResponse entry){
		entryList.add(entry);
	}

	public void transferFunds(AccountResponse toAccount, double amount, String description){
		AccountEntryResponse fromEntry = new AccountEntryResponse(new Date(), -amount, description, ""+toAccount.getAccountNumber(), toAccount.getCustomerResponse().getName());
		AccountEntryResponse toEntry = new AccountEntryResponse(new Date(), amount, description, ""+toAccount.getAccountNumber(), toAccount.getCustomerResponse().getName());
		entryList.add(fromEntry);	
		toAccount.addEntry(toEntry);
	}
	
	public CustomerResponse getCustomerResponse() {
		return customer;
	}

	public void setCustomerResponse(CustomerResponse customer) {
		this.customer = customer;
	}

	public void setEntryList(Collection<AccountEntryResponse> entryList) {
		this.entryList = entryList;
	}

	public CustomerResponse getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerResponse customer) {
		this.customer = customer;
	}

	public Collection<AccountEntryResponse> getEntryList() {
		return entryList;
	}

}
