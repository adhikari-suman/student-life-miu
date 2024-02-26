package lesson6.employeephase2.employeeinfo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private Date hireDate;
	
	public Employee(String name, int year, int month, int day){
		this.name = name;
		GregorianCalendar cal = new GregorianCalendar(year, month, day);
		hireDate = cal.getTime();
	}
	
	public void createNewSavings(double startBalance){
		savingsAcct = new Account(this,Account.SAVINGS,startBalance);
	}
	public void createNewChecking(double startBalance){
		checkingAcct = new Account(this,Account.CHECKING,startBalance);
	}
	public void createNewRetirement(double startBalance){
		retirementAcct = new Account(this,Account.RETIREMENT,startBalance);

	}
	public void deposit(String acctType, double amt){
		if(!Account.isValidAcctType(acctType)){
			System.out.println(acctType +" is not a valid account type");
			return;
		}
		if(acctType.equals(Account.CHECKING)){
			this.checkingAcct.makeDeposit(amt);
		}
		if(acctType.equals(Account.SAVINGS)){
			this.savingsAcct.makeDeposit(amt);
		}
		if(acctType.equals(Account.RETIREMENT)){
			this.retirementAcct.makeDeposit(amt);
		}		
		
	}
	
	public boolean withdraw(String acctType, double amt){
		boolean success = false;
		if(!Account.isValidAcctType(acctType)){
			System.out.println(acctType + " is not a valid account type");
			return false;
		}
		if(acctType.equals(Account.CHECKING)){
			success =  this.checkingAcct.makeWithdrawal(amt);
		}
		if(acctType.equals(Account.SAVINGS)){
			success = this.savingsAcct.makeWithdrawal(amt);
		}
		if(acctType.equals(Account.RETIREMENT)){
			success = this.retirementAcct.makeWithdrawal(amt);
		}
		if(!success){
			System.out.println("Unable to perform withdrawal -- amount exceeds balance");
		
		}
		return success;
		
	}
	public String getName() {
		return name;
	}
	public Date getHireDate(){
		Date returnVal = (Date)hireDate.clone();
		return returnVal;
	}
	private String n = System.getProperty("line.separator");
	public String getFormattedAccountInfo(){
		String retVal = "ACCOUNT INFO FOR "+name+":"+n+n;
		if(this.checkingAcct!=null){
			retVal += (checkingAcct.toString()+n);
		}
		if(this.savingsAcct!=null){
			retVal += (savingsAcct.toString()+n);
		}		
		if(this.retirementAcct != null){
			retVal += (retirementAcct.toString()+n);
		}
		return retVal;
	}
}
