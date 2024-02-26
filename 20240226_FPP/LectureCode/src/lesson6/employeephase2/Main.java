package lesson6.employeephase2;

import java.awt.EventQueue;

import lesson6.employeephase2.employeeinfo.Employee;



public class Main {
	Employee[] emps;
	
	public static void main(String[] args) {
		new Main();
	}
	Main(){
		emps = new Employee[3];
		emps[0] = new Employee("Jim Daley", 2000, 9, 4);
		emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
		emps[2] = new Employee("Susan Randolph", 1997, 2,13);
		
		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);
		
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				UserIO ui = new UserIO(Main.this);
				ui.setOutputString("See a report of all account balances? (y/n)");
				ui.setOutputValue();
				ui.setVisible(true);
			}
		});	
		

	}
	
	String getAllAccounts(){
		String retVal = "";
		String n = System.getProperty("line.separator");
		for(Employee emp : emps){
			retVal += emp.getFormattedAccountInfo();
			retVal += n;
		}
		return retVal;
	}

}
