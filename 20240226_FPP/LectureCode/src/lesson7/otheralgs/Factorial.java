package lesson7.otheralgs;

public class Factorial {

	static int numCalls = 0;
	public static void main(String[] args) {
		final int n = 15;
		Factorial f = new Factorial();
		f.factorial(n);
		System.out.println("Num calls to compute factorial("+n+") = " + numCalls);
	}
	int factorial(int n) {
		++numCalls;
		System.out.println("Computing factorial("+n+")");
		if(n == 0 || n == 1) {
			return 1;
		}
		int retVal = n * factorial(n-1);
		System.out.println("Returning val "+retVal+" in computing factorial("+n+")");
		return retVal;
	}


}
