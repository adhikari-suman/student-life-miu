package lesson2.modulus;

public class ModulusTest {

	public static void main(String[] args) {
		///////////////old way
		System.out.println("5 mod 4 = "+ (5 % 4));
		
		//gives negative answer (which is crazy)
		System.out.println("-5 mod 4 = " + (-5 % 4) + ", which is negative!"); 
		
		//////////////java 8 way
		System.out.println("5 mod 4 = " + Math.floorMod(5, 4));
		
		//gives correct answer
		System.out.println("-5 mod 4 = " + Math.floorMod(-5, 4) + ", which is >= 0, as it should be");
		
		//integer division is also corrected in Java 8
		System.out.println("-5 / 4 = " + Math.floorDiv(-5, 4) + ", which is the floor of -5/4 using regular division");
		
		//division algorithm works properly in java 8
		System.out.println("Using Java 8 we have: ");
		System.out.println(4 * Math.floorDiv(-5,4) + Math.floorMod(-5, 4) + " = 4 * Math.floorDiv(-5,4) + Math.floorMod(-5, 4)");

	}

}
