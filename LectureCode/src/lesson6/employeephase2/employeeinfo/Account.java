package lesson6.employeephase2.employeeinfo;

public class Account {
	public final static String CHECKING = "checking";
	public final static String SAVINGS = "savings";
	public final static String RETIREMENT = "retirement";
	public final static String[] types = {CHECKING,SAVINGS,RETIREMENT};
	
	private Employee emp;
	private String acctType; //possilbe values: CHECKING, SAVINGS, RETIREMENT
	private double balance;

	Account(Employee e, String acctType, double startBalance) {
		emp = e;
		balance = startBalance;
		this.acctType = acctType;
		
	}
	Account(Employee e, String acctType) {
		this(e,acctType,0.0);
	}
	static boolean isValidAcctType(String type){
		for( String t : types){
			if(t.equals(type)) {
				return true;
			}
			
		}
		return false;
	}
	void makeDeposit(double amount){
		balance += amount;
	}
	boolean makeWithdrawal(double amount){
		if(amount > balance){
			return false;
		}
		balance -= amount;
		return true;
	}
	double getBalance(){
		return balance;
	}
	public Employee getEmp(){
		return emp;
	}
	private String newline = System.getProperty("line.separator");
	public String toString(){
		String ret =
			"Account type: "+acctType+newline+
			"Current bal:  "+balance;
		return ret;
	}
	
}
