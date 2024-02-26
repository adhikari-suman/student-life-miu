package lesson7.otheralgs;

/**
 * The method here recursively separates
 * the input string, which consists of a mix
 * of letters and digits, into a string in
 * which all of the original digits occur in
 * their original order in the left side 
 * of the string, and all original alpha chars
 * occur in their original order in the right side.
 * @author Administrator
 *
 */
public class SeparateLettersDigits {
	StringBuilder digits = new StringBuilder();
	StringBuilder alphas = new StringBuilder();
	public String separate(String input) {
		if(input == null || input.isEmpty()) return input;
		recursiveSeparate(input);
		return digits.toString() + alphas.toString();
	}
	
	private void recursiveSeparate(String s) {
		if(s.isEmpty()) return;
		char ch = s.charAt(0);
		if(Character.isDigit(ch)) digits.append(ch);
		else alphas.append(ch);
		recursiveSeparate(s.substring(1));
	}
	
	public static void main(String[] args) {
		SeparateLettersDigits sld = new SeparateLettersDigits();
		System.out.println(sld.separate("1a2b3cdef9zywu8"));
	}
}
