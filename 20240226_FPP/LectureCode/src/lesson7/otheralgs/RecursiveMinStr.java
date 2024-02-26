package lesson7.otheralgs;

/**
 * The logic:
 * Let ch = str.charAt(0);
 * Let c = min of str.substring(1)
 * return the smaller of the two
 *
 */
public class RecursiveMinStr {
	public Character rmin(String str) {
		if(str == null || str.length() == 0) {
			return null;
		}
		char ch = str.charAt(0);
		if(str.length() == 1) return ch;
		char c = rmin(str.substring(1));
		return (ch < c ? ch : c);
	}
	public int minpos(String str) {
		if(rmin(str) == null) return -1;
		return str.indexOf(rmin(str));
	}
	
	public static void main(String[] args) {
		RecursiveMinStr m = new RecursiveMinStr();	
		System.out.println(m.rmin("befageeeAhi"));
	}
}
