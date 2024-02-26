package lesson7.otheralgs;

import java.util.Arrays;

/**
 * This class provides recursive merging of two
 * sorted int arrays.
 * Usage: After instantiating Merge, 
 * the public merge method should be called, passing in
 * the two arrays to be merged. 
 * Note: The method gives unpredictable results if the
 * initial arrays are not each in sorted order initially.
 */
public class Merge {
	public static void main(String[] args){
		int[] arr1 = {1,3,5,7,9,11,13};
		int[] arr2 = {2,4,6,8,10,12,14,16,18,20};
		Merge m = new Merge();
		int[] result = m.merge(arr1,arr2);
		System.out.println(Arrays.toString(result));
		//output:
		//[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 18, 20]
	}
	
	/**
	 * This is the public merge method whose signature and return value are user-friendly
	 * @param arr1, arr2 - the already sorted input arrays
	 * @return int[] - the array of merged values, in sorted order
	 */
	public int[] merge(int[] arr1, int[] arr2){
		if(arr1 == null) return arr2;
		if(arr2 == null) return arr1;
		int len1 = arr1.length;
		int len2 = arr2.length;
		int[] retVal = new int[len1+len2];
		return recursiveMerge(retVal,0,arr1, arr2);
	}
	
	//private recursive method that does the real work
	private int[] recursiveMerge(int[] returnVal, int nextPosRet, int[] first, int[] second){
		if(first.length == 0){
			System.arraycopy(second,0,returnVal,nextPosRet,second.length);
			return returnVal;
		}
		if(second.length==0){
			System.arraycopy(first,0,returnVal,nextPosRet,first.length);
			return returnVal;
		}
		if(first[0] <= second[0]){
			returnVal[nextPosRet] = first[0];
			return recursiveMerge(returnVal, nextPosRet+1, remove0th(first),second);
		}
		else {
			returnVal[nextPosRet] = second[0];
			return recursiveMerge(returnVal, nextPosRet+1, first,remove0th(second));
		}
	}
	
	private int[] remove0th(int[] arr){
		if(arr == null || arr.length==0) return null;
		int[] retVal = new int[arr.length-1];
		System.arraycopy(arr,1,retVal,0,arr.length-1);
		return retVal;
	}
}
