package lab04_20240302.prog3;

import java.util.Scanner;

import lab04_20240302.prog3.employeeinfo.*;

public class Main {

	private static Employee[] employees;
	private static boolean exit = false;

	static {
		employees = new Employee[3];
		employees[0] = new Employee("Jim Daley", 2000, 9, 4);
		employees[1] = new Employee("Bob Reuben", 1998, 1, 5);
		employees[2] = new Employee("Susan Randolph", 1997, 2, 13);

		employees[0].createNewChecking(10500);
		employees[0].createNewSavings(1000);
		employees[0].createNewRetirement(9300);

		employees[1].createNewChecking(34000);
		employees[1].createNewSavings(27000);

		employees[2].createNewChecking(10038);
		employees[2].createNewSavings(12600);
		employees[2].createNewRetirement(9000);

	}

	public static void main(String[] args) {

		do {
			showMainMenu();
		} while (!exit);

	}

	public static void showMainMenu() {
		System.out.println("A. See a report of all accounts.");
		System.out.println("B. Make a deposit.");
		System.out.println("C. Make a withdrawal. ");
		System.out.print("Make a selection (A/B/C): ");

		// Get input
		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		// for case B and C
		Employee selected;

		// switch case
		switch (input) {

		case "A":
		case "a":
			showAllAccountsData();
			break;

		case "B":
		case "b":
			selected = showSelectEmployeeMenu();

			if(selected == null) {
				System.out.println("\nInvalid choice! Please try again!\n");
				return;
			};
			
			showTransactionMenu(selected, TransactionType.DEPOSIT);

			break;

		case "C":
		case "c":
			selected = showSelectEmployeeMenu();
			
			if(selected == null) {
				System.out.println("\nInvalid choice! Please try again!\n");
				return;
			};

			showTransactionMenu(selected, TransactionType.WITHDRAWL);
			break;

		default:
			System.out.println("\nWrong input! Please try again.\n");
			break;
		}
	}

	public static void showAllAccountsData() {
		StringBuilder sb = new StringBuilder("\n");

		for (var e : employees) {
			sb.append(e.getFormattedAcctInfo());
		}
		System.out.print(sb);
	}

	public static Employee showSelectEmployeeMenu() {
		// Build the menu
		StringBuilder sb = new StringBuilder("\n");

		for (int i = 0; i < employees.length; i++) {
			sb.append(String.format("%d. %s\n", i, employees[i].getName()));
		}

		sb.append("Select an employee: (type a number) ");

		// show the menu
		System.out.print(sb);

		// Get user input
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();

		// return the employee if in range
		if (index >= 0 && index < employees.length) {
			return employees[index];
		} else {
			return null;
		}

	}

	// Recursion is not used here, so the user starts from scratch every time
	public static void showTransactionMenu(Employee e, TransactionType t) {
		if (e == null) {
			System.out.println("Invalid choice. Please try again! ");
		}

		// Account index for transaction
		int index = -1;

		switch (t) {
		case DEPOSIT:
			index = selectAccountForTransaction(e);

			if (index == -1) {
				System.out.println("\nWrong account selected. Try again!\n");
				return;
			}

			double depositAmt = getAmountForTransaction("deposit");
			e.deposit(index, depositAmt);
			break;

		case WITHDRAWL:
			index = selectAccountForTransaction(e);

			if (index == -1) {
				System.out.println("Wrong account selected. Try again! ");
				return;
			}
			double withdrawAmt = getAmountForTransaction("withdraw");
			e.withdraw(index, withdrawAmt);
			break;

		default:
			break;
		}

	}

	private static int selectAccountForTransaction(Employee e) {
		showListOfAccounts(e);

		System.out.print("Select an account: (type a number) ");

		Scanner sc = new Scanner(System.in);
		int accIndex = sc.nextInt();

		if (accIndex < 0 || accIndex >= e.getNamesOfAccounts().length) {
			return -1;
		} else {
			return accIndex;
		}
	}

	private static void showListOfAccounts(Employee e) {
		String[] accList = e.getNamesOfAccounts();

		StringBuilder sb = new StringBuilder("\n");

		for (int i = 0; i < accList.length; i++) {
			sb.append(String.format("%d. %s\n", i, accList[i]));
		}

		System.out.print(sb);
	}

	private static double getAmountForTransaction(String str) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print(String.format("\nAmount to %s: ", str));
		return scan.nextDouble();
	}

}
