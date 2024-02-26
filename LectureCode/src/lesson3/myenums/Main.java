package lesson3.myenums;

public class Main {
	public static void main(String[] args) {
		System.out.println(typeOf(MyEnum.SECOND));
		System.out.println(MyEnum2.FIRST.val());
		MyEnum2.FIRST.modify();
		System.out.println(MyEnum2.FIRST.val());
		
	}
	static boolean typeOf(MyEnum val) {
		if(val == MyEnum.FIRST) return true;
		else return false;
	}
}
