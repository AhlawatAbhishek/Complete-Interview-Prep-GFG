package Hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithGivenSum {
//	Time complexity : O(n^2) and auxiliary space : 0(1)
	public static boolean isSum(int arr[], int n, int target) {
		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i];
			if (sum == target) {
				return true;
			}
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				if (sum == target) {
					return true;
				}
			}
		}
		return false;
	}

//	Time complexity : O(n) and auxiliary space : O(n)
	public static boolean isSum2(int arr[], int n, int target) {
		Set<Integer> set = new HashSet<>();
		int preSum = 0;
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];
			if (set.contains(preSum - target)) {
				return true;
			}
			if (preSum == target) {
				return true;
			}
			set.add(preSum);
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 8, 6, 13, 3, -1 };
		int sum = 22;
		int n = arr.length;

		System.out.println(isSum2(arr, n, sum));
	}

}
