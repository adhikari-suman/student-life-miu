package lesson3.staticvble;

public class Main {

	public static void main(String[] args) {
		MyClass c1 = new MyClass(2);
		MyClass c2 = new MyClass(5);
		System.out.println("Value of x in c1: " + c1.x);
		System.out.println("Value of x in c2: " + c2.x);
		MyClass c3 = new MyClass(33);
		System.out.println("Value of x in c1: " + c1.x);
		System.out.println("Value of x in c2: " + c2.x);
		System.out.println("Value of x in c3: " + c3.x);


	}

}
