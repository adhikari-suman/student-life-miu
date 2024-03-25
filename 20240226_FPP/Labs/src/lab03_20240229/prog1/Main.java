package lab03_20240229.prog1;

public class Main {

	public static void main(String[] args) {
		// Create Employee
		Employee e = new Employee("Ankhtuya Ochirbat","Ankha", 240000, 2015, 12,13);

		// Create 3 accounts
		Account checkingAcct = new Account(e,AccountType.CHECKING ,300.0);
		Account savingsAcct = new Account(e,AccountType.SAVINGS ,300.0);
		Account retirementAcct = new Account(e,AccountType.RETIREMENT ,300.0);

		// Print the accounts
		System.out.println(checkingAcct);
		System.out.println(savingsAcct);
		System.out.println(retirementAcct);
		
	}

}
