package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSpanWithSameSum {
	public static int longestCommonSum(int[] arr1, int[] arr2, int n) {
		int temp[] = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = arr1[i] - arr2[i];
		}
		int preSum1 = 0, maxLen = 0;
		Map<Integer, Integer> map1 = new HashMap<>();
		for (int i = 0; i < n; i++) {
			preSum1 += temp[i];

			if (preSum1 == 0) {
				maxLen = Math.max(maxLen, i + 1);
			}
			if (map1.containsKey(preSum1 - 0)) {
				maxLen = Math.max(maxLen, i - map1.get(preSum1 - 0));
			} else {
				map1.put(preSum1, i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] arr1 = { 0, 1, 0, 1, 1, 1, 1 };
		int[] arr2 = { 1, 1, 1, 1, 1, 0, 1 };
		int n = arr1.length;
		System.out.println(longestCommonSum(arr1, arr2, n)); // TODO Auto-generated method stub

	}

}
