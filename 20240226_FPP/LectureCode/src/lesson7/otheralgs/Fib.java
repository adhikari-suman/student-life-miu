package lesson7.otheralgs;

public class Fib {
	static int numCalls = 0;
	
	public static void main(String[] args) {
		final int n = 12;
		Fib f = new Fib();
		f.fib(n);
		System.out.println("Num calls to compute fib(" + n + "): " + numCalls);

	}
	int fib(int n) {
		++numCalls;
		System.out.println("Computing f("+n+")");
		if(n == 0 || n == 1) {
			return n;
		}

		int retVal = fib(n-1) + fib(n-2);
		System.out.println("Returning val "+retVal+" for computation of fib("+n+")");
		return retVal;
	}
	

}
