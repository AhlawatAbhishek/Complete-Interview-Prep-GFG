package Searching;

public class CountNumberOfOccurrencesOfAnElementInSortedArray {

//	Time complexity: O(LogN) and auxiliary space: O(1)
	public static int lastOccurrence1(int arr[], int n, int key) {
		int lo = 0, hi = n - 1, ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] < key) {
				lo = mid + 1;
			} else if (arr[mid] > key) {
				hi = mid - 1;
			} else {
				ans = mid;
				lo = mid + 1;
			}
		}
		return ans;
	}

//	Time complexity: O(LogN) and auxiliary space: O(1)
	public static int firstOccurrence1(int arr[], int n, int key) {
		int lo = 0, hi = n - 1, ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] < key) {
				lo = mid + 1;
			} else if (arr[mid] > key) {
				hi = mid - 1;
			} else {
				ans = mid;
				hi = mid - 1;
			}
		}
		return ans;
	}

//	Time complexity: O(LogN) and auxiliary space: O(1)
	public static int countOcc(int arr[], int n, int x) {
		int lastOcc = lastOccurrence1(arr, n, x);
		if (lastOcc == -1) {
			return -1;
		}
		int firstOcc = firstOccurrence1(arr, n, x);
		return (lastOcc - firstOcc + 1);
	}

	public static void main(String args[]) {
		int arr[] = { 10, 20, 20, 20, 40, 40 }, n = 6;

		int x = 20;

		System.out.println(countOcc(arr, n, x));

	}
}
