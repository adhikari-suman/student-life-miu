package lesson12.exceptionsdemo;

public class DataDisplayer {
	private Employee[] emps;
	public DataDisplayer(Employee[] emps) {
		this.emps = emps;
	}
	public void displayData() {

		//print info about Employee 1
		System.out.println(emps[0].toString());
		System.out.println(" Home address: "+ emps[0].getHome().toString());
		System.out.println(" Work address: " + emps[0].getWork().toString());
		

		
		//Search the array for an Employee having first name "Bill"
		//If found, print out the Employee's full name
		for(int i = 0; i < emps.length; ++i) {
			String firstName = emps[i].getFirstName();
			if(firstName.equals("Bill")) {
				System.out.println("Found Bill! " + emps[i].toString());
			}
		}
	}
}
