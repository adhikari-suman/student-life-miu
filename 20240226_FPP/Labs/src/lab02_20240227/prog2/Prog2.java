package lab02_20240227.prog2;

public class Prog2 {
	public static void main(String... args) {
		// 1. get a random number x in the range 1 .. 9 and compute π^x
		int x = RandomNumbers.getRandomInt(1, 9);
		
		double pi_powered_to_x = Math.pow(Math.PI,x);
		
		System.out.printf("π^%d = %f\n",x, pi_powered_to_x);
		
		// 2. get a random number y in the range 3 .. 14 and compute y^π
		int y = RandomNumbers.getRandomInt(3, 14);
		double y_powered_to_pi = Math.pow(y, Math.PI);
		
		System.out.printf("%d^%f = %f",y,Math.PI,y_powered_to_pi );
	}
}
