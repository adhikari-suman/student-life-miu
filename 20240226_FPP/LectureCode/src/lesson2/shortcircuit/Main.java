package lesson2.shortcircuit;

public class Main {

	public static void main(String[] args) {
		and(4);
		and(-1);
		and(10);
		or(-1);
		or(10);
		or(4);
		//System.out.printf("%,d",1000);

	}
	
	public static void and(int x) {
		if(x > 0 && x < 5) {
			System.out.println("true");
		} else {  //x <= 0 || x >= 5
			System.out.println("false");
		}
	}
	
	public static void or(int x) {
		if(x < 0 || x > 5) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
