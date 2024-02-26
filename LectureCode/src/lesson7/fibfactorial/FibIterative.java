package lesson7.fibfactorial;

/** This class provides two iterative solutions to 
 * computing nth Fibonacci number.
 *
 */
public class FibIterative {
	public static void main(String[] args) {
		FibIterative fi = new FibIterative();
		System.out.println("fib(10) = " + fi.fib1(10));
		System.out.println("fib(10) = " + fi.fib2(10));
	}
	
	int[] store;
	/** This approach uses auxiliary space */
	public int fib1(int n) {
		store = new int[n+1];
		store[0] = 0;
		store[1] = 1;
		for(int i = 2; i <= n; ++i) {
			store[i] = store[i-1] + store[i-2];
		}
		return store[n];
	}
	
	/** This approach keeps track of previous values using two variables 
	 *  so auxiliary space not needed
	 */
	public int fib2(int n) {
		int previous1, previous2;
		if(n == 0 || n == 1) return n;
		previous1 = 1;
		previous2 = 0;
		int current = previous1 + previous2;
		for(int i = 0; i < n-2; ++i) {
			int temp = previous1 + current;
			previous2 = previous1;
			previous1 = current;
			current = temp;
			//System.out.println(current);			
		}
		return current;
	}
}
