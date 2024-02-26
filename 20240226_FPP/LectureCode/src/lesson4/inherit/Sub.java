package lesson4.inherit;

/**
 * Illustrates the fact that access of variables does not
 * use dynamic binding. The variable is associated with the
 * static type at compile time.
 * 
 * In the Sup class, the code
 *    Sup s = new Sub();
	  int z = s.x;
   is not concerned with the runtime type of s -- so the 
   value of x that is used is the value contained in the superclass Sup.
   
   In the Sub class, s.x is not visible for the usual reason: x is private
   in Sup.
 * @author paul_
 *
 */
public class Sub extends Sup{
	int x = 2;
	
	public static void main(String[] args) {
		Sup s = new Sub();
		//int z = s.x; //doesn't compile

	}
}
