package lab08_20240313.prog5;

public class MyTable {
	private Entry[] entries;

	{
		entries = new Entry[26];
	}

	// returns the String that is matched with char c in the table
	public String get(char c) {
		// implement
		String s = null;

		for (int i = 0; i < entries.length; i++) {
			Entry e = entries[i];

			if (e.ch == c) {
				s = e.str;
			}
		}

		return s;
	}

	// adds to the table a pair (c, s) so that s can be looked up using c
	public void add(char c, String s) {
		Entry e = new Entry(s, c);

		final int START = 'a';
		final int END = 'z';

		if (c < START || c > END) {
			return;
		}
		// 'a' - 'a' = 0,|| 'z' - 'a' = 25
		int index = c - START;		
		entries[index] = e;

	}

	// returns a String consisting of nicely formatted display
	// of the contents of the table
	public String toString() {
		// implement

		StringBuilder sb = new StringBuilder("\n");

		for (Entry e : entries) {
			if (e != null) {
				sb.append(e + "\n");
			}
		}

		return sb.toString();
	}

	private class Entry {
		private char ch;
		private String str;

		Entry(String str, char ch) {
			// implement
			this.ch = ch;
			this.str = str;
		}

		// returns a String of the form "ch->str"
		public String toString() {
			// implement
			return String.format("%c->%s", ch, str);
		}
	}

	public static void main(String... args) {
		MyTable t = new MyTable();
		t.add('a', "Andrew");
		t.add('b', "Billy");
		t.add('w', "Willie");
		t.add('z', "Zillie");
		System.out.println(t);
	}

}