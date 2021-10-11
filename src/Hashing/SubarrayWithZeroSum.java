package Hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithZeroSum {
//	Time complexity : O(n^2) and auxiliary space : 0(1)
	public static boolean ZeroSumSubarray(int arr[], int n) {
		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i];
			if (sum == 0) {
				return true;
			}
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				if (sum == 0) {
					return true;
				}
			}
		}
		return false;
	}

//Prefix Sum
//	Time complexity : O(n) and auxiliary space : O(N)
	public static boolean ZeroSumSubarray2(int arr[], int n) {
		Set<Integer> set = new HashSet<>();
		int preSum = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];
			if (set.contains(preSum)) {
				return true;
			}
			set.add(preSum);
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 3, 9, -4, -6, 7, -1 };
		int n = arr.length;

		System.out.println(ZeroSumSubarray2(arr, n));
	}

}
