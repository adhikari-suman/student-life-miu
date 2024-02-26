package lesson2.floatingpoint;

public class FPArithmetic {
	public static void main(String[] args) {
		//multiply();
		equality();
		//floatInBinary();
	}
	//multiplication of floats leads to round-off error
	public static void multiply() {
		float x = 2.3456F;
		float y = 5.4193F;
		double x1 = 2.3456;
		double y1 = 5.4193;
		System.out.println("Multiplication of doubles: " + x1 * y1);
		System.out.println("Multiplication of floats: " + x * y);
	}
	
	/**
	 * Illustrates that decimal 0.1 cannot be represented exactly as a floating point number
	 * and the right and wrong way to test equality between floating point numbers
	 */
	public static void equality() {
		double a = 0.7        ;
	    double b = 0.9        ;
	    double x = a + 0.1    ;
	    double y = b - 0.1    ;
	    System.out.println("a = " + a + "  b = " + b);
	    //wrong way to test equality since representations are not exact
	    System.out.println("Is x equal to y? " + (x == y));
	    System.out.println("x = 0.7 + 0.1 = " + x);
	    System.out.println("y = 0.9 - 0.1 = " + y);
	    //correct way to test for equality
	    //pick a number z that can in current context be "nearly" zero
	    //(for instance, for salaries, .0000001 is an amount that is so small
	    //it is nearly 0)
	    double z = 0.0000001;
	    System.out.println("Is x equal to y? " 
	        + (Math.abs(x - y) < z));
	    
	}
	/**
	 * OPTIONAL: Formula for internal representation of a float in binary:
	 *     (-1)^s * [ 2^(e-127) * 1 + 2^(e-127) * m]
	 * where s is the 0th bit (0 means positive, 1 means negative)
	 * and e is exponent byte which is next 8 bits (so from 0 to 255), and m is
	 * mantissa, the last 23 bits
	 */
	public static void floatInBinary() {
		float x = 0.1f;
		//need to pad in front to ensure that bit string is 32 digits
		System.out.println("Bits in 0.1: " + "00" + Integer.toBinaryString(Float.floatToIntBits(x)));
		System.out.println("length = " + ("00" + Integer.toBinaryString(Float.floatToIntBits(x))).length());
		System.out.println("sign bit = 0  (the leftmost bit)");
		System.out.println("exponent byte e = " + "01111011" + " and e - 127 is " + (Integer.parseInt("01111011",2)-127));
		System.out.println("mantissa = " + "10011001100110011001101");
		System.out.println("compute 2^(-4) * 1 + 2^(-4) * 10011001100110011001101 = 0001 + 000010011001100110011001101");
		System.out.println("full binary representation = 000110011001100110011001101");
		double y = .1 + .7;
		System.out.println("decimal value of this bit string = " + (y-.7));

	}
}
