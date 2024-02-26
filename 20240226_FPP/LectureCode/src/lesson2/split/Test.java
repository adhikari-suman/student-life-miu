package lesson2.split;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		String s = "hi.there:friend|joe";
		String[] vals = s.split("\\.|\\||:");
		
		System.out.println(Arrays.toString(vals));
		
		//can avoid complicated escape sequences using Pattern.quote
		String s2 = "hi|there|friend|joe";
		String[] vals2 = s2.split(Pattern.quote("|"));
		System.out.println(Arrays.toString(vals2));
		
		
	}

}
