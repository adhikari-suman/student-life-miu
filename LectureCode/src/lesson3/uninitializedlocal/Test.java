package lesson3.uninitializedlocal;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		t.myMethod();
	}
	
	public void myMethod() {
		int x=0;
		System.out.println(x);
	}

}
