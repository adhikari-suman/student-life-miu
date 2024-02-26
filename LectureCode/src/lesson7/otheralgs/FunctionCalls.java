package lesson7.otheralgs;

public class FunctionCalls {
	
	public static void main(String[] args) {
		first();

	}
	static void first(){
		System.out.println("entered first");
		second();
		System.out.println("exiting first");
	}
	
	static void second(){
		System.out.println("entered second");
		third();
		System.out.println("exiting second");
	}	
	
	static void third(){}

}
