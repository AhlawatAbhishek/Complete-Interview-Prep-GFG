package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {
	public static int largestSubarrayWithSumX(int arr[], int n, int sum) {
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			int currSum = 0;
			for (int j = i; j < n; j++) {
				currSum += arr[j];
				if (currSum == sum) {
					maxLen = Math.max(maxLen, j - i + 1);
				}
			}
		}
		return maxLen;
	}

//Time complexity : 0(n) and auxiliary space : O(N)
	public static int largestSubarrayWithSumX2(int arr[], int n, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxLen = 0, preSum = 0;
		for (int i = 0; i < n; i++) {
			preSum += arr[i];
			if (preSum == sum) {
				maxLen = Math.max(maxLen, i + 1);
			}
			if (map.containsKey(preSum - sum)) {
				maxLen = Math.max(maxLen, i - map.get(preSum - sum));
			} else {
				map.put(preSum, i);
			}

		}
		return maxLen;

	}

	public static void main(String[] args) {
		int arr[] = new int[] { 8, 3, -7, -4, 1 };
		int n = arr.length;
		int sum = -8;

		System.out.println(largestSubarrayWithSumX2(arr, n, sum));
	}

}
