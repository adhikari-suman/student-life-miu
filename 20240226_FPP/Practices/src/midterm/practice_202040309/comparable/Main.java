package midterm.practice_202040309.comparable;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Integer[ ] a= {1,2,23,11, 3,4,5};
		
		Arrays.sort(a, (o1,o2)-> o1.compareTo(o2) );

	}

}
