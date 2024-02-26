package lesson3.orderofexec.demo;


public class ClassE {
	
	private static int staticInt = 1;
	
	private int number = 2;
	
	public static int staticMethod(){
		System.out.println("Hello");
		return 1;
	}
	
	ClassE(int num){
		this.number = num; 
		System.out.println("Constructor hello");
	}
	
	{
		//Object initialization block
		System.out.println("Object initialization block");
	}
	
	static {
		//Static initialization block
		System.out.println("Static block");
	}
	public static void main(String[] args) {
		new ClassE(3);

	}


}
