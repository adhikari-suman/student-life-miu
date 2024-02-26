package lesson2.equalstrings;

public class Test {

	public static void main(String[] args) {
		String r = "Robert";
		System.out.println(r == "Robert");
		
		String s = new String("Robert");
		System.out.println(s == "Robert");
		
		System.out.println(r == s);
		System.out.println(r.equals(s));

	}

}
