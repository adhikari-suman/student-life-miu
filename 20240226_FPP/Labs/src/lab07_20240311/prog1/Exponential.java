package lab07_20240311.prog1;

public class Exponential {

	double power(double x,int n) {
		// edge-case for n < 0, illegal argument
		if(n<0) return 0;
		
		if(n==0) return 1;
		
		return x * power(x, n-1);
	}
	
	public static void main(String[] args) {
		Exponential exp = new Exponential();
		
		System.out.println(String.format("%d ^ %d = %f", 2, 10,exp.power(2, 10)));
	}

}
