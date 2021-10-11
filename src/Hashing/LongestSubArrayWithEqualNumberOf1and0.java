package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithEqualNumberOf1and0 {
	public static int largestZeroOneSubarray(int arr[], int len) {
		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		int preSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];
			if (preSum == 0) {
				maxLen = Math.max(maxLen, i + 1);
			}
			if (map.containsKey(preSum - 0)) {
				maxLen = Math.max(maxLen, i - map.get(preSum - 0));
			} else {
				map.put(preSum, i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 1, 1, 0, 1, 0, 1, 1, 1 };
		int len = arr.length;

		System.out.println(largestZeroOneSubarray(arr, len));
	}

}
