package Searching;

public class LeftMostOccurrenceOfAnElement {
//	Time complexity: O(N) and auxiliary space: O(1)
	public static int firstOccurrence(int arr[], int n, int x) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;
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

//	Time complexity: O(LogN) and auxiliary space: O(LogN)
	public static int firstOccurrRec(int arr[], int lo, int hi, int key) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		if (arr[mid] < key) {
			lo = mid + 1;
		} else if (arr[mid] > key) {
			hi = mid - 1;
		} else {
			if (mid == 0 || arr[mid - 1] != arr[mid]) {
				return mid;
			}
			hi = mid - 1;
		}
		return firstOccurrRec(arr, lo, hi, key);
	}

	public static void main(String[] args) {
		int arr[] = { 5, 10, 10, 15, 15 }, n = 5;

		int x = 15;

		System.out.println(firstOccurrence(arr, n, x));
		System.out.println(firstOccurrence1(arr, n, x));
		System.out.println(firstOccurrRec(arr, 0, n - 1, x));

	}

}
