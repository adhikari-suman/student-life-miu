package midterm.practice_202040309;

import java.util.Arrays;

public interface ArraysPractice {
	public static void main(String... args) {
		int[] a = { 1, 4, 2, 3, 7, 11, -1, 0 };
		
		int[] b = Arrays.copyOf(a, a.length);
		
		Arrays.sort(a);
		
		int[] c = new int[a.length];
		
		System.arraycopy(a, 0, c, 0, c.length);
		
		System.out.printf("Array: %s\n",Arrays.toString(a));
		System.out.printf("Array: %s\n",Arrays.toString(b));
		System.out.printf("Array: %s\n",Arrays.toString(c));
	}
}
