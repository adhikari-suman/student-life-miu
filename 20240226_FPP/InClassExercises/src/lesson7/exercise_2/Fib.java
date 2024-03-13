package lesson7.exercise_2;

public class Fib {

	// find nth item of fibonacci series
	// -1 means some error
	public int fib(int n) {
		// 0, 1, 1
		int num = 0;

		if (n < 0) {
			num = -1;
		} else if (n == 0 || n == 1) {
			num = n ;
		} else {
			for (int a = 0, b = 1, i = 2; i <= n; i++) {
				num = a + b;
				a = b;
				b = num;
			}
		}

		return num;

	}

	public static void main(String[] args) {
		Fib f = new Fib();
		System.out.println(f.fib(10));

		
		System.out.println();
		System.out.println(f.fib(0));
		System.out.println(f.fib(1));
		System.out.println(f.fib(2));
		System.out.println(f.fib(3));
		System.out.println(f.fib(4));
		System.out.println(f.fib(5));
		System.out.println(f.fib(6));
		System.out.println(f.fib(7));
		System.out.println(f.fib(8));
		System.out.println(f.fib(9));
		System.out.println(f.fib(10));

	}
}
