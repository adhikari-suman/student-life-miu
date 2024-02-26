package lesson8.exercise_1;

import java.util.Arrays;

public class MinSort {
	public MinSort(int[] input) {
		this.arr = input;
	}
	private int[] arr;

	public void sort() {
		if (arr == null || arr.length <= 1)
			return;
		int len = arr.length;
		for (int i = 0; i < len; ++i) {
			// find position of min value from arr[i] to arr[len-1]
			int nextMinPos = minpos(i, len - 1);

			// place this min value at position i
			swap(i, nextMinPos);
		}
	}

	// Swaps values arr[i], arr[j]
	void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Returns pos of min value from
	// positions i to j
	int minpos(int i, int j) {
		int pos = i;
		int min = arr[i];
		for (int k = i + 1; k <= j; ++k) {
			if (arr[k] < min) {
				pos = k;
				min = arr[k];
			}
		}
		return pos;
	}
	
	public static void main(String[] args) {
		int[] arr = {9,8, 3, 6, 11};
		MinSort ms = new MinSort(arr);
		ms.sort();
		System.out.println(Arrays.toString(arr));
		
	}

}
