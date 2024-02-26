package lesson7.fibfactorial;

/** Recursive computation of Fibonacci numbers */
public class Fib {
	
	public static void main(String[] args) {
		Fib f = new Fib();
		f.fib(12);
	}
	
	public int fib(int n) {
		System.out.printf("Entering fib with n = %d%n", n);
		if(n == 0 || n == 1) {
			System.out.printf("Entering base case with n = %d%n", n);
			System.out.printf("Returning val %d of fib(%d) in base case\n", n, n);
			return n;
		}

		int retVal = fib(n-1) + fib(n-2);
		System.out.printf("Returning val %d of fib(%d)%n", retVal, n);
		return retVal;
	}
	

}
