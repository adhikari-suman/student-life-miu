package lab07_20240311.prog2;

public class MinSort {

	public String sort(String s) {
		if (s == null || s.isEmpty())
			return s;
		// 1. Find the position minpos of the alphabetically least character in s
		int minPos = minpos(s, 0, s.length() - 1);

		// 2. Swap the character in position 0 with the character ch in position minpos
		String swappedStr = swap(s, 0, minPos);

		// 3. Remove character ch from the string, store it, and call the remaining
		// String t

		String newStr = swappedStr.substring(1);
		// 4. Sort t and place in storage to the right of the character ch

		String sortedString = swappedStr.charAt(0) + sort(newStr);
		// 5. Return the stored String.

		return sortedString;
	}

	public String swap(String s, int idx1, int idx2) {
		StringBuilder sb = new StringBuilder(s);

		char ch1 = sb.charAt(idx1);
		char ch2 = sb.charAt(idx2);

		sb.setCharAt(idx2, ch1);
		sb.setCharAt(idx1, ch2);
		
		return sb.toString();
	}

//	public void sort(){
//		String arr = new String();
//		
//		
//	if(arr == null || arr.length() <=1) return;
//	int len = arr.length();
//	for(int i = 0; i < len; ++i){
//	//find position of min value from arr[i] to arr[len-1]
//	int nextMinPos = minpos(i,len-1);
//	//place this min value at position i
//	swap(i, nextMinPos);
//	}
//	}

	// Returns pos of min value from
	// positions i to j
	int minpos(String s, int i, int j) {
		int pos = i;
		int min = s.charAt(i);
		for (int k = i + 1; k <= j; ++k) {
			if (s.charAt(k) < min) {
				pos = k;
				min = s.charAt(k);
			}
		}
		return pos;
	}

	public static void main(String... args) {
		MinSort ms = new MinSort();
		String result = ms.sort("zwxuabfkafutbbbb");
		System.out.println(result);
	}

}
