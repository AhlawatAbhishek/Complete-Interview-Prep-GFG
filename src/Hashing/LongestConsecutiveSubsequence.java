package Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
//	Time complexity : O(NlogN) and auxiliary space : O(1) 
	public static int findLongest(int arr[], int n) {
		Arrays.sort(arr);
		int maxLen = 0, currCount = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1] + 1) {
				currCount++;
			} else if (arr[i] != arr[i - 1]) {
				maxLen = Math.max(maxLen, currCount);
				currCount = 1;
			}
		}
		return maxLen;
	}

	public static int findLongest1(int arr[], int n) {
		int maxLen = 0;
		Set<Integer> set = new HashSet<>();
		for (int i : arr) {
			set.add(i);
		}
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i] - 1)) {
				int count = 1;
				while (set.contains(arr[i] + count)) {
					count++;
				}
				maxLen = Math.max(maxLen, count);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 9, 3, 4, 2, 10, 13 };

		int n = arr.length;

		System.out.println(findLongest1(arr, n));
	}

}
