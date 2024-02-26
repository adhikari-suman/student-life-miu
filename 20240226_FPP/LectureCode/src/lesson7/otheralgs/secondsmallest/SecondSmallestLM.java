package lesson7.otheralgs.secondsmallest;


public class SecondSmallestLM {
	
	public Character rsmin(String str) {
		if (str == null || str.length() <= 1) {
			throw new IllegalArgumentException("Not enough elements in input array");	
		}
		Character[] twoSmallest = rsmin(str, str.length());
		return twoSmallest[1];
	}
	/**
	 * 
	 * @param str
	 * @param length
	 * @return an array of two smallest elements in the String str. 
	 * 		   0th element is the smallest, and 1st element is the second smallest
	 * @author MeiLi
	 */
	private Character[] rsmin(String str, int length) {

		Character[] arr = new Character[2];
		char first = str.charAt(0);
		
		if(length == 2){
			char second = str.charAt(1);
			arr[0] = first < second ? first : second;
			arr[1] = second <= first ? first : second;
			return arr;
		}
		Character[] anotherTwoSmallest = rsmin(str.substring(1), length-1 );
		if ( first <= anotherTwoSmallest[0]){
			arr[0] = first;
			arr[1] = anotherTwoSmallest[0];
		}
		else if ( first <= anotherTwoSmallest[1]){
			arr[0] = anotherTwoSmallest[0];
			arr[1] = first;
		}
		else {
			arr[0] = anotherTwoSmallest[0];
			arr[1] = anotherTwoSmallest[1];
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		SecondSmallestLM rsm = new SecondSmallestLM();
		System.out.println(rsm.rsmin("thxbasbd"));
	}
}
