package Sorting;

import java.util.Arrays;

public class MergeOverlappingIntervals {
//	TIme complexity: O(nLogn) and auxiliary space: O(1)
	public static void mergeIntervals(int arr[][], int n) {
		Arrays.sort(arr, (a, b) -> a[1] - b[1]);
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[res][1] >= arr[i][0]) {
				arr[res][0] = Math.min(arr[res][0], arr[i][0]);
				arr[res][1] = Math.max(arr[res][1], arr[i][1]);
			} else {
				res++;
				arr[res][0] = arr[i][0];
				arr[res][1] = arr[i][1];
			}
		}
		for (int i = 0; i <= res; i++) {
			System.out.print("{" + arr[i][0] + ", " + arr[i][1] + "}, ");
		}
	}

	public static void main(String[] args) {
		int arr[][] = { { 5, 10 }, { 3, 15 }, { 18, 30 }, { 2, 7 } };
		int n = arr.length;
		mergeIntervals(arr, n);
	}

}
