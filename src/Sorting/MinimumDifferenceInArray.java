package Sorting;

import java.util.Arrays;

public class MinimumDifferenceInArray {
//	Time complexity: O(N^2) and auxiliary space : O(1)
	public static int getMinDiff(int arr[]) {
		int n = arr.length, minDiff = Integer.MAX_VALUE;
		if (n == 1)
			return minDiff;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[j]));
			}
		}
		return minDiff;
	}

//Time complexity : O(N) and auxiliary space : O(1)
	public static int getMinDiff2(int arr[]) {
		int n = arr.length, minDiff = Integer.MAX_VALUE;
		if (n == 1) {
			return minDiff;
		}
		Arrays.sort(arr);
		for (int i = 0; i < n - 1; i++) {
			minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i + 1]));
		}
		return minDiff;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 8, 12, 5, 18 };
		System.out.println(getMinDiff(arr));
	}

}
