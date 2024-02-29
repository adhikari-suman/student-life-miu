package lab03_20240228.prog6;

import java.util.Arrays;

public class Prog6 {	
	public static String[] removeDups(String[] arr) {
		// 1. Create a dummy array to hold unique variables
		int length = 0;
		String[] uniqueArr = new String[arr.length];
		
		// 2. Get each string in array,
		// check if its already in uniqueArr
		// if yes, do nothing, if no add to uniqueArr and increment length by 1
		for(String s: arr) {
			// flag to check if duplicate exists
			boolean isDuplicate = false;
			
			for(int i=0; i<length;i++) {
				String str = uniqueArr[i];
				
				// if duplicate is found break and go to the next string
				if(s.equals(str)) {
					isDuplicate = true;
					break;
				}
			}
			
			// if no duplicate found, add it to the unique array
			if(!isDuplicate) {
				uniqueArr[length] = s;
				length++;
			}
		}
		
		// 3. Create the actual reverse array with the same length
		String[] reverseArray = Arrays.copyOf(uniqueArr, length);
		return reverseArray;
	}
}
