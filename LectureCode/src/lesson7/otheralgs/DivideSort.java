package lesson7.otheralgs;

import lesson7.mergestrings.MergeStrings;

/**
 * MergeSort implementation for chars in a string
 *
 */
public class DivideSort {
	public String sort(String s) {
		if(s==null || s.isEmpty()) return s;
		return recSort(s);
		
	}
	private String recSort(String s) {
		if(s.isEmpty() || s.length() == 1) return s;
		int m = s.length()/2;
		String u = recSort(s.substring(0,m));
		String v = recSort(s.substring(m));
		return (new MergeStrings()).merge(u,v);
	}
	
	public static void main(String[] args) {
		DivideSort ds = new DivideSort();
		System.out.println(ds.sort("zwaxyuevbunmt"));
	}
}
