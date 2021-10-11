package Searching;

public class AllocateMinimumPages {
	public static int sum(int arr[], int b, int e) {
		int sum = 0;
		for (int i = b; i <= e; i++) {
			sum += arr[i];
		}
		return sum;
	}

//Time complexity : Exponential and auxiliary space: Exponential
	public static int minPages(int arr[], int n, int k) {
		if (n == 1) {
			return arr[0];
		}
		if (k == 1) {
			return sum(arr, 0, n - 1);
		}

		int minPages = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			minPages = Math.min(minPages, Math.max(sum(arr, i, n - 1), minPages(arr, i, k - 1)));
		}
		return minPages;
	}

	// Time complexity : O(n*log(sum - max)) and auxiliary space: O(1)
	public static int minPages1(int arr[], int n, int k) {
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i : arr) {
			max = Math.max(max, i);
			sum += i;
		}
		int lo = max, hi = sum, res = Integer.MIN_VALUE;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (isFeasible(arr, mid, k)) {
				res = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return res;
	}

	public static boolean isFeasible(int arr[], int ans, int givenStudents) {
		int reqStudents = 1, sumOfPages = 0;
		for (int i : arr) {
			if (sumOfPages + i > ans) {
				ans = i;
				reqStudents++;
			} else {
				sumOfPages += i;
			}
		}
		return reqStudents <= givenStudents;
	}

	public static void main(String args[]) {
		int arr[] = { 10, 20, 10, 30 };
		int n = arr.length;
		int k = 2;

		System.out.print(minPages(arr, n, k));
	}
}
