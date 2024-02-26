package lesson5.comparators;

import java.util.Arrays;
import java.util.Comparator;

import lesson5.comparators.data.PersonData;

/**
 * This version is a replacement for MainAnonymous.
 * A lambda is anonymously defined in the
 * sort method.
 *
 */
public class MainLambdaAnonymous {
	public static void main(String[] args) {
		Person[] persons = PersonData.personData;
		Arrays.sort(persons, 
			(p1,p2)-> p1.getName().compareTo(p2.getName()));
		System.out.println(Arrays.toString(persons));
	}	
}




