package lesson7.otheralgs.secondsmallest;

public class SecondSmallest {

	public static void main(String[] args) {
		int[] arr = {4, 5, 2, 3, 17, 4, 11, 5, 8};
		SecondSmallest ss = new SecondSmallest();
		System.out.println(ss.secondSmallest(arr));
	}
	
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
			smallestTwo = smallestTwo(x,y,tail(arr, 2));
		}
		return smallestTwo[0]<smallestTwo[1] ? smallestTwo[1] : smallestTwo[0];
	}
	
	private int[] tail(int[] arr, int amt) {
		int[] end = new int[arr.length - amt];
		System.arraycopy(arr, amt, end, 0, arr.length-amt);
		return end;
	}
	
	private int[] smallestTwo(int a, int b, int[] arr) {
		if(arr.length == 0) return new int[] {a, b};
		int c = arr[0];
		int[] bestTwo = smallestTwoFromThree(a, b, c);
		return smallestTwo(bestTwo[0], bestTwo[1], tail(arr, 1));
	}
	
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
