package lab01_20240226;

public class ArraySearch {
	public static int search(int arr[], int target) {
		// Check if arr is null or empty
		if (arr == null || arr.length == 0) {
			return -1;
		}

		// find the target
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}

		// default return
		return -1;
	}
}
