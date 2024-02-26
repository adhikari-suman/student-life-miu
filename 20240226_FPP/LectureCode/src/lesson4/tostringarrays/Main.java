package lesson4.tostringarrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String[] people = {"Bob", "Harry", "Sally"};
		
		//wrong way
		System.out.println(people.toString());
		
		//right way
		System.out.println(Arrays.toString(people));

	}

}
