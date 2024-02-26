package lesson2.unicode;

public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		String unicodeString = "\u7ec8\u6781\u7684\u77db\u76fe\u70b9";
		//Easy way if Windows and Eclipse are set up for chinese 
		//characters and UTF-8 encoding
		System.out.println(unicodeString);
		
		//However, if you don't have utility or font set 
		//to render the characters, you get garbage
		
		//See http://home.tiscali.nl/t876506/UnicodeDisplay.html 
		//for a list of unicode codes for all BMP characters
		
		//The following prepares unicodeString for display in a browser
		String toConvert = "\\u7ec8\\u6781\\u7684\\u77db\\u76fe\\u70b9";
		String delimitersChanged = convertEscapeUtoNCR(toConvert);
		String[] arr = delimitersChanged.split("[&#]");
		StringBuilder sb = new StringBuilder();
		for(String x : arr) {
			if(!x.equals("")) {
				sb.append(";&#" + base16tobase10(x));
			}
		}//base16tobase10
		String result = sb.toString();
		System.out.println(result.substring(1));
		
		System.out.println("\u2286");
		String x = "\u2286";
		System.out.println(x);

	}
	
	public static String base16tobase10(String s) {
		return Integer.valueOf(s,16).toString();
	}
	public static String convertEscapeUtoNCR(String s) {
		return  s.replaceAll("u", "#").replaceAll("\\\\","&");
		
	}
	public static String base10convert(int x) {
		return "\\" + "u" + Integer.toString(x, 16);
		
	}
	
	public static void testChineseChars() {
		System.out.println("终极的矛盾点"); 
	}

}
