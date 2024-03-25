package lab02_20240228.prog8;

public class Prog8 {

	public static int min(int[] arrayOfInts) {
		// 1. set integer to maximum value for failsafe
		int min = Integer.MAX_VALUE;
		
		// 2. find the min
		for(int num:arrayOfInts) {
			if(num < min) {
				min = num;
			}
		}
		
		
		// 3. return min
		return min;
	}

}
