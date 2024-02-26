package lesson4.inherit;

public class Sup {
	private int x = 1;
	
	
	public static void main(String[] args) {
		Sup s = new Sub();
		int z = s.x;
		System.out.println("" + z);
		
	}
}
