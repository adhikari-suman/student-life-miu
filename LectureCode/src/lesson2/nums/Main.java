package lesson2.nums;

public class Main {

	public static void main(String[] args) {
		int x = (int)Math.pow(2, 30);
		System.out.println(x);
		//adding x to x produces a number that is bigger than the range of int
		//causes overflow of the int type
		System.out.println(x + x);
		
		//write x as a binary string -- it's a postive number so begins with 0
		System.out.println("0" + Integer.toBinaryString(x) 
		     + " length: " + ("0" + Integer.toBinaryString(x)).length());
		
		//write x + x as a binary string -- it's a negative num so begins with 1
		System.out.println(Integer.toBinaryString(x+x) + " length: " + Integer.toBinaryString(x+x).length());
		
		//the long type is big enough to represent the integer 2^31 without overflow
		long y = (long)Math.pow(2, 31);
		System.out.println(y);
		
	}

}
