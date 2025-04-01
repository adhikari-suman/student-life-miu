import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.IntStream;

public class Problem01Solution {

    static int order = 0;

    public static void main(String[] args) {

        Problem01Solution solution = new Problem01Solution();

        int[] input = new int[]{100, 0, 99, 1, 98, 2, 97, 3, 96, 4, 95, 5, 94, 6,
                                93, 7, 92, 8, 91, 9, 90, 10, 89, 11, 88, 12, 87, 13,
                                86, 14, 85, 15, 84, 16, 83, 17, 82, 18, 81, 19, 80,
                                20, 79, 21, 78, 22, 77, 23, 76, 24, 75, 25, 74, 26,
                                73, 27, 72, 28, 71, 29, 70, 30, 69, 31, 68, 32, 67,
                                33, 66, 34, 65, 35, 64, 36, 63, 37, 62, 38, 61, 39,
                                60, 40, 59, 41, 58, 42, 57, 43, 56, 44, 55, 45, 54,
                                46, 53, 47, 52, 48, 51, 49, 50 };
        System.out.printf("Input: %s%n", Arrays.toString(input));

        solution.mergeSortPlus(input, 0, input.length - 1);

        System.out.printf("Result: %s", Arrays.toString(input));
    }

    void insertionSort(int[] arr, int lower, int upper) {
        int temp = 0;
        int j    = 0;

        for (int i = lower; i <= upper; i++) {
            temp = arr[i];
            j    = i;

            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = temp;
        }
    }


    void mergeSortPlus(int[] arr, int lower, int upper) {
        if (upper - lower + 1 < 20) {
            insertionSort(arr, lower, upper);
        } else {
            int mid = lower + (upper - lower) / 2;

            mergeSortPlus(arr, lower, mid);
            mergeSortPlus(arr, mid + 1, upper);

            merge(arr, lower, mid, upper);
        }
    }

    void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid -low + 1;
        int n2 = high - mid;


        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[low + i];
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[mid + i + 1];
        }

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
}
