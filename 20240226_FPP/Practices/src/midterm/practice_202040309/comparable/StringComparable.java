package midterm.practice_202040309.comparable;

public class StringComparable implements Comparable<String> {

	String s;
	
	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return s.length() - o.length();
	}

}
