package Searching;

public class FindPeakElement {
//	peak element is the element not smaller than its neighbors
//	Time complexity: O(N) and auxiliary space: O(1)
	public static int getPeak(int[] arr, int n) {
		if (arr.length == 1) {
			return arr[0];
		}
		if (arr[0] >= arr[1]) {
			return arr[0];
		}
		if (arr[n - 1] >= arr[n - 2]) {
			return arr[n - 1];
		}
		for (int i = 1; i < n - 1; i++) {
			if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
				return arr[i];
			}
		}
		return -1;

	}

//	Time complexity: O(LogN) and auxiliary space: O(1)
	public static int getPeak1(int arr[], int n) {
		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid > 0 && arr[mid] <= arr[mid - 1]) {
				hi = mid - 1;
			} else if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
				return arr[mid];
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 10, 11, 12, 20, 12 }, n = 6;
		System.out.println(getPeak(arr, n));
		System.out.println(getPeak1(arr, n));
	}

}
