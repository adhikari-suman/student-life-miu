package sortroutines;

import runtime.Sorter;

public class MergeSortPlus extends Sorter {

	//public sorter
	public int[] sort(int[] input){
		mergeSortPlus(input, 0, input.length - 1);

		return input;
	}

	void insertionSort(int[] arr, int lower, int upper) {
		int temp = 0;
		int j    = 0;

		for (int i = lower + 1; i <= upper; i++) {
			temp = arr[i];
			j    = i;

			while (j > lower && temp < arr[j - 1]) { // Ensuring we compare within bounds
				arr[j] = arr[j - 1];
				j--;
			}

			arr[j] = temp;
		}
	}

	void mergeSortPlus(int[] arr, int lower, int upper) {
		if (upper - lower + 1 <= 20) {
			insertionSort(arr, lower, upper);
		} else {
			int mid = lower + (upper - lower) / 2;

			mergeSortPlus(arr, lower, mid);
			mergeSortPlus(arr, mid + 1, upper);

			merge(arr, lower, mid, upper);
		}
	}

	void merge(int[] arr, int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;

		// Copy data into temp arrays, but more efficiently using System.arraycopy
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];

		System.arraycopy(arr, low, arr1, 0, n1);
		System.arraycopy(arr, mid + 1, arr2, 0, n2);

		int left = 0, right = 0;
		int index = low;
		while (left < n1 && right < n2) {
			if (arr1[left] < arr2[right]) {
				arr[index++] = arr1[left++];
			} else {
				arr[index++] = arr2[right++];
			}
		}

		while (left < n1) {
			arr[index++] = arr1[left++];
		}

		while (right < n2) {
			arr[index++] = arr2[right++];
		}
	}

	public static void main(String[] args){
		MergeSortPlus ms = new MergeSortPlus();

		int[] arr = {23, 1, 2, 11, 26, 11, 23, 22, -9, 1, 11, 38,
					 23, 1, 2, 11, 26, 11, 23, 22, -9, 1, 11, 38,
					 23, 1, 2, 11, 26, 11, 23, 22, -9, 1, 11, 38,
					 23, 1, 2, 11, 26, 11, 23, 22, -9, 1, 11, 38
		};
		int[] returnArr = ms.sort(arr);
		for (int i : returnArr) {
			System.out.print(i + " ");
		}
	}
}
