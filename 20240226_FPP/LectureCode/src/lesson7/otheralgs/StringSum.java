package lesson7.otheralgs;

/**
 * Given a String of 0s and 1s in sorted order,
 * the method here computes the
 * sum of the digits in sublinear time.
 * If input String is null, returns -1.
 *
 */
public class StringSum {
	int sum = 0;
	//counts number of chars examined
	//starts with 2 since we examine first and last
	int count = 2;
	public int computeDigitSum(String s) {
		if(s == null) return -1;
		if(s.length() == 0) return 0;
		if(s.charAt(0) == '1') {
			return s.length();
		}
		if(s.charAt(s.length()-1) == '0') {
			return 0;
		}
		recSum(s);
		return sum;
	}
	
	private void recSum(String s) {
		if(s.length() == 0){ 
			return;			
		}
		int m = s.length()/2;
		if(s.charAt(m) == '1') {
			++count;
			sum += s.length() - m;
			recSum(s.substring(0, m));
		} else {
			recSum(s.substring(m+1));
		}
	}
	
	public static void main(String[] args) {
		String test1 = "000000000";
		String test2 = "111111111111111";
		String test3 = "0000111111111";  //9
		String test4 = "0000000000111";  //3
		StringSum ss = null;
		
		System.out.println("------------------------");
		System.out.println("test1 -- sum should be 0");
		ss = new StringSum();
		System.out.println("  " + ss.computeDigitSum(test1));
		System.out.println("  num chars examined: " + ss.count);
		
		System.out.println("------------------------");
		System.out.println("test2 -- sum should be 15");
		ss = new StringSum();
		System.out.println("  " + ss.computeDigitSum(test2));
		System.out.println("  num chars examined: " + ss.count);
		
		System.out.println("------------------------");
		System.out.println("test3 -- sum should be 9");
		ss = new StringSum();
		System.out.println("  " + ss.computeDigitSum(test3));
		System.out.println("  num chars examined: " + ss.count);
		
		System.out.println("------------------------");
		System.out.println("test4 -- sum should be 3");
		ss = new StringSum();
		System.out.println("  " + ss.computeDigitSum(test4));
		System.out.println("  num chars examined: " + ss.count);
	}
}
