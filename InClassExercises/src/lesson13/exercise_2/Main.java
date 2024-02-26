package lesson13.exercise_2;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//implement
		findStreet("535811101");
		//readPerson("John");
		//System.out.println("=============================");
		//readAllPersons();
		//System.out.println("=============================");
		//readAllWhoLiveOn("Adams");
	}
	/* Reads from the fppdb database all street names of addresses belonging to persons having ssn = 535811101 */
	private static void findStreet(String ssn) {
		ReadPerson rp = new ReadPerson();
		System.out.printf("Looking up streets of persons with ssn = %s", "535811101");
		//implement
	}
	
	private static void readPerson(String firstName) {
		ReadPerson rp = new ReadPerson();
		System.out.printf("Looking up %s", firstName);
		try {
			Person cust = rp.getPerson(firstName);
			System.out.println(cust);
		} catch(SQLException e) {
				System.out.println("Error: " + e.getMessage());
		}
	}
	
	private static void readAllPersons() {
		System.out.println("Listing all Persons");
		ReadPerson rp = new ReadPerson();
		try {
			List<Person> persons = rp.getPersonList();
			System.out.println(persons);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void readAllWhoLiveOn(String streetName) {
		System.out.println("All Persons who live on " + streetName);
		ReadPerson rp = new ReadPerson();
		try {
			List<Person> custs = rp.getPersonsOnStreet(streetName);
			System.out.println(custs);
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
