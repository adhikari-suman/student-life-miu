package lesson3.orderofexec;

public class ClassE {

	@SuppressWarnings("unused")
	private static int staticInt = staticMethod();
	@SuppressWarnings("unused")
	private int number = initializeVariable();
	
	public static int staticMethod(){
		System.out.println("1-Initializing static variable staticInt");
		return 1;
	}

	public int initializeVariable() {
		System.out.println("3-Initializing instance variable");
		return 1;
	}
	
	ClassE(int num){
		this.number = num; //problem?
		System.out.println("5-Running ClassE constructor");
	}
	
	{
		//Object initialization block
		System.out.println("4-Running object initialization block");
	}
	
	static {
		//Static initialization block
		System.out.println("2-Executing static block");
	}
	public static void main(String[] args) {
		new ClassE(3);

	}

}
