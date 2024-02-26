package lesson5.comparators;

import java.util.Arrays;
import java.util.Comparator;

import lesson5.comparators.data.PersonData;

/**
 * This version is a replacement for MainComparator
 * using lambdas. A named lambda comp is defined and
 * then passed to the sort method.
 *
 */
public class MainLambda {
	public static void main(String[] args) {
		Person[] persons = PersonData.personData;
		Comparator<Person> comp 
		     = (p1,p2)-> p1.getName().compareTo(p2.getName());
		Arrays.sort(persons, comp);
		System.out.println(Arrays.toString(persons));
	}	
}


