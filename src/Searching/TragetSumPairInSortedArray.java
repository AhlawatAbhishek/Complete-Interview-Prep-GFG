package Searching;

public class TragetSumPairInSortedArray {
//	Time complexity: O(N) and auxiliary space: O(1)
	public static boolean isPresent(int A[], int n, int target) {
		int lo = 0, hi = A.length - 1;
		while (lo < hi) {
			int sum = A[lo] + A[hi];
			if (sum == target) {
				return true;
			} else if (sum > target) {
				hi--;
			} else {
				lo++;

			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 7, 8, 11 };
		int n = arr.length;
		int sum = 14;

		System.out.println(isPresent(arr, n, sum));

	}

}
