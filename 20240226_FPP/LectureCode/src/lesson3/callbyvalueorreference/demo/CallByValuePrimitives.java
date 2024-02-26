package lesson3.callbyvalueorreference.demo;

public class CallByValuePrimitives {
	public static void main(String[] args) {
		CallByValuePrimitives c = new CallByValuePrimitives();
		int num = 50;
		c.triple(num);
		//What is the value of num now?
		System.out.println(num);
		
	}
	public void triple(int x) {
		x = 3 * x;
	}
}
