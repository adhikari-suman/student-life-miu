package lesson4.orderofexec_demo;

public class ClassE {

	static int staticInt;
	
	static {
		System.out.println("static block");
	}
	
	private int superInstanceInt;
	
	ClassE(){
		System.out.println("constructor");
	}
	
	{
		System.out.println("initialization block");
	}
	public static void main(String[] args) {
		new SubClass();
	}
}

class SubClass extends ClassE {
	static int subInt;
	
	static {
		System.out.println("sub static block");
	}

	SubClass(){
		System.out.println("SubClass constructor");
	}
	{
		System.out.println("sub object initialization block");
	}		
}
