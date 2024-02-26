package lesson7.otheralgs.secondsmallest;

/**
 * This version uses array indices instead of breaking
 * the array apart repeatedly, so it is more efficient
 * than SecondSmallest
 * 
 * The Algorithm: Pull off the first two elements of the array,
 * and call them a, b. The values for a, b will be updated
 * during the recursion so that at the end, they will be the
 * two smallest elements of the array. This is accomplished
 * by scanning the array's elements one by one, and for each
 * c in the array, computing the smallest two among a, b, c.
 * The smallest two found in this way become the new values for a, b.
 * 
 * Finally, the second smallest value among a, b is returned.
 * 
 * @author pcorazza
 *
 */
public class SecondSmallestIndex {
	public static void main(String[] args) {
		int[] arr = {4, 5, 2, 3, 17, 4, 11, 5, 8};
		SecondSmallestIndex ss = new SecondSmallestIndex();
		System.out.println(ss.secondSmallest(arr));
	}
	
	/** Returns the second smallest element in arr, using recursion. */
	public int secondSmallest(int[] arr) {
		if(arr == null || arr.length < 2) {
			throw new IllegalArgumentException("Not enough elements in input array");		
		}
		int[] smallestTwo = null;
		
		if(arr.length == 2) {
			smallestTwo = arr;
		} else {
			int x = arr[0];
			int y = arr[1];
			smallestTwo = smallestTwo(x,y, 2, arr);
		}
		return smallestTwo[0]<smallestTwo[1] ? smallestTwo[1] : smallestTwo[0];
	}
	
	/** Returns the two smallest values from arr. For the current index,
	 *  the smallest values found so far are a, b
	 *  
	 * @param a, b - Smallest values found in the array so far, through index-1
	 * @param index - the next array position to check
	 * @param arr - the input array given at the beginning
	 * @return - a two-element array containing the two smallest elements of arr
	 */
	private int[] smallestTwo(int a, int b, int index, int[] arr) {
		if(index >= arr.length) return new int[] {a, b};
		int c = arr[index];
		int[] bestSoFar = smallestTwoFromThree(a, b, c);
		return smallestTwo(bestSoFar[0], bestSoFar[1], index + 1, arr);
	}
	
	/** Returns in an int array the two smallest values from among u, v, w .
	 *  Note: they may not be in sorted order. 
	 */
	private int[] smallestTwoFromThree(int u, int v, int w) {
		if(u <= v) {
			if(v <= w) return new int[] {u, v};
			else return new int[] {u, w};
		} else { // u > v
			if(u > w) return new int[] {v, w};
			else return new int[] {u, v};
		}
	}
}
