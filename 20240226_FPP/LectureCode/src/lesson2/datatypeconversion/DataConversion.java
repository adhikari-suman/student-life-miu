package lesson2.datatypeconversion;

public class DataConversion {

	public static void main(String[] args) {
		
		//int -> long, int -> double automatic, no loss of info
		int x = 123456789;
		long y = x;
		double w = x;
		System.out.printf("int to long or double: %d, %d, %f\n", x, y, w);
		
		
		//int -> float: automatic but may lose info
		int a = 123456789;
		float b = a;
		System.out.printf("int to float: %d, %f\n", a,b);
		
		//long -> float, long -> double: automatic but may lose info 
		long c = 123456789123456789L;
		float d = c;
		double e = c;
		System.out.printf("long to float or double: %d, %f, %f\n", c,d,e);
		
		//char -> int - automatic, nothing lost
		char s = 'a';
		int t = s;
		System.out.printf("char to int: %c, %d", s, t);
		char k = '点';
		int z = k;
		System.out.println("  " + k + " : " + z);
		
		//compiler error if cast is not done
		byte u = 10;
		byte v = 11;
		byte sum = (byte)(u + v);
		
		System.out.printf("owe $%10.2f\n", 195.50f);
		System.out.printf("owe $%.2f", 195.50f);
		
		
		

	}

}
