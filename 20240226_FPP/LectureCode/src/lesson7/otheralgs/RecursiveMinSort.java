package lesson7.otheralgs;

/**
 * Sorts characters in a string using a StringBuilder.
 * Same idea works on array, but requires more work.
 *
 */
public class RecursiveMinSort {
	RecursiveMinStr m = new RecursiveMinStr();
	StringBuilder ret = new StringBuilder();
	public String minSort(String input) {
		StringBuilder sb = new StringBuilder(input);
		sb = minsort(sb);
		return sb.toString();	
	}
	
	private StringBuilder minsort(StringBuilder input) {
		int pos = m.minpos(input.toString());
		if(pos == -1) return ret;
		ret.append(input.charAt(pos));
		swap(input, 0, pos);
		return minsort(new StringBuilder(input.substring(1)));	
	}
	
	StringBuilder swap(StringBuilder sb, int i, int j) {
		if(i < 0 || j < 0) throw new IllegalArgumentException("Invalid swap inputs");
		if(i >= sb.length() || j >= sb.length()) throw new IllegalArgumentException("Invalid swap inputs");
		char c = sb.charAt(i);
		char d = sb.charAt(j);
		sb.replace(j, j+1, "" + c);
		sb.replace(i, i+1, "" + d);
		return sb;
	}
	public static void main(String[] args) {
		
		RecursiveMinSort rms = new RecursiveMinSort();
		/*
		StringBuilder sb = new StringBuilder("ab");
		System.out.println(rms.swap(sb, 0, 1).toString());
		*/
		
		String s = "abcddcbaeexxyyzz";
		System.out.println(rms.minSort(s));
		
	}
}
