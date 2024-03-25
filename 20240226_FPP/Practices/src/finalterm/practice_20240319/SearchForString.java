package finalterm.practice_20240319;

import java.util.Arrays;

public class SearchForString {
	private String[] arr;

	public SearchForString(String[] arr) {
		this.arr = arr;
	}

	public boolean search(String s) {

		for (String str : arr) {
			if (str.equals(s)) {
				return true;
			}
		}

		return false;
	}

	private boolean recurSearch(String s, int upperIndex) {

		if (upperIndex < 0 || upperIndex >= arr.length) {
			return false;
		}

		return s.equals(arr[upperIndex]) || recurSearch(s, upperIndex - 1);
	}

	public static void main(String... strings) {
		var strArr = new String[] { "Hello", "World", "It's", "a", "beautiful", "world!" };
		var searchLists = new String[] { "Hello", "Cruel", "beautiful" };
		SearchForString s = new SearchForString(strArr);

		System.out.printf("Search recursively for %s in %s: Found = %b\n", searchLists[0], Arrays.toString(strArr),
				s.recurSearch(searchLists[0], strArr.length - 1));
		System.out.printf("Search recursively for %s in %s: Found = %b\n", searchLists[1], Arrays.toString(strArr),
				s.recurSearch(searchLists[1], strArr.length - 1));

		System.out.printf("Search iteratively for %s in %s: Found = %b\n", searchLists[2], Arrays.toString(strArr),
				s.search(searchLists[0]));
		System.out.printf("Search iteratively for %s in %s: Found = %b\n", searchLists[1], Arrays.toString(strArr),
				s.search(searchLists[1]));

	}
}
