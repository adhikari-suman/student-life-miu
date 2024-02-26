package lesson7.otheralgs;

/**
 * This is a recursive solution to the following problem:
 * You are given a length-n int array A which contains a subset
 * of the integers S={0,1,2,...,n}. The elements of A are in sorted
 * order and are distinct. Find (in sublinear time) the integer
 * in A that does not belong to A.
 * 
 * Algorithm: Search(A)
 *   if(A[0] != 0) return 0.
 *   if(A[n-1] == n-1) return n.
 *   return Search(A, 0, n-1)
 * 
 * SubRoutine: Search(A, lower, upper) 
 *    mid <- (upper+lower)/2
 *    if(A[mid]==mid) return Search(A, mid+1, upper)
 *    else //A[mid]>mid
 *       if(A[mid-1]==mid-1) return A[mid]-1
 *       else return Search(A, lower, mid-1)
 *    
 *    
 * @author pcorazza
 *
 */
public class MissingNum {
	public int search(int[] nums) {
		int n = nums.length;
		if(nums == null || nums.length == 0) {
			throw new IllegalArgumentException("Input array contains no elements");
		}
		if(nums[0] != 0) return 0;
		if(nums[n-1] == n-1) return n;
		return recurSearch(nums, 0, n-1);
	}
	private int recurSearch(int[] nums, int lower, int upper) {
		int mid = (lower + upper)/2;
		if(nums[mid] == mid) { //search the right half
			return recurSearch(nums, mid + 1, upper);
		} else {  //nums[mid] > mid
			if(nums[mid-1] == mid-1) return nums[mid]-1;
			else return recurSearch(nums, lower, mid-1);
		}
	}
	public static void main(String[] args) {
		int[] test1 = {0, 1, 2, 3, 4, 6, 7, 8, 9};
		int[] test2 = {1, 2, 3,4, 5, 6};
		int[] test3 = {0,1,2,3,4,5, 6};
		MissingNum mn = new MissingNum();
		System.out.println(mn.search(test1));
		System.out.println(mn.search(test2));
		System.out.println(mn.search(test3));
	}
}
