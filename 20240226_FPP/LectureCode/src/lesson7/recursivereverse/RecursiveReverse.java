package lesson7.recursivereverse;

public class RecursiveReverse {

	public static void main(String[] args) {
		System.out.println(reverse("Hello"));

	}

	private static String reverse(String s) {
		if(s.length() == 0) return s;
		String first = "" + s.charAt(0);
		return  reverse(s.substring(1)) + first;
	}
}
