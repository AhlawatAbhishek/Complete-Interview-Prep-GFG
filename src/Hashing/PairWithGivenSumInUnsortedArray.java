package Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSumInUnsortedArray {
//	Time complexity : O(N) and space complexity or auxiliary space : O(N)
	public static int pairWithSumX(int[] arr, int len, int x) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(x - arr[i])) {
				return 1;
			}
			set.add(arr[i]);
		}
		return 0;
	}

//	Time complexity : O(NLogN) and space complexity or auxiliary space : 0(1)
	public static int pairWithSumX2(int ar[], int len, int x) {
		Arrays.sort(ar);
		int l = 0, r = ar.length - 1;
		while (l <= r) {
			int sum = ar[l] + ar[r];
			if (sum < x) {
				l++;
			} else if (sum > x) {
				r--;
			} else {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 8, 4, 7, 6, 1 };
		int len = arr.length;
		int x = 8;
		System.out.println(pairWithSumX(arr, len, x));
	}

}
