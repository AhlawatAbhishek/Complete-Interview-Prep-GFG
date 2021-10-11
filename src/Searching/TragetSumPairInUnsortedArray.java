package Searching;

import java.util.HashSet;

public class TragetSumPairInUnsortedArray {
//	Time complexity: O(N) and auxiliary space: O(N)
	public static void printpairs(int arr[], int n) {
		HashSet<Integer> set = new HashSet<>();
		for (int i : arr) {
			int target = n - i;
			if (set.contains(target)) {
				System.out.println(i + " " + target);
			}
			set.add(i);
		}
	}

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int n = 16;
		printpairs(A, n);

	}

}
