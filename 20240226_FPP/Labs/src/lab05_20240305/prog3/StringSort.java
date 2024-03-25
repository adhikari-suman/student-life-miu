package lab05_20240305.prog3;

import java.util.Arrays;
import java.util.Comparator;

public class StringSort {
	
	private Comparator<String> myComparator;
	
	StringSort(Comparator<String> myComparator){
		this.myComparator = myComparator;
	}
	
	public String[] stringSort(String[] arr) {
		Arrays.sort(arr, myComparator);
		
		return arr;
		
	}
}
