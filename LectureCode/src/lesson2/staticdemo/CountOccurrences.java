package lesson2.staticdemo;

/** 
 * Illustrates the use of static methods: They accept one or more
 * inputs, process them, and return a value. They do not attempt
 * to access instance variables in the surrounding class.
 *
 */
public class CountOccurrences {
	public static void main(String[] args) {
		System.out.println(countOccurrences("apple",'p'));
		System.out.println(countOccurrences("apple", 't'));
	}
	/** 
	 * Counts and returns the number of occurrences of char c in
	 * string s
	 */
	public static int countOccurrences(String s, char c) {
		if(s == null || s.length() == 0) return 0;
		int count = 0;
		for(int i = 0; i < s.length(); ++i) {
			if(s.charAt(i) == c) count++;
		}
		return count;
	}
}
