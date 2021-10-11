package Searching;

public class RightMostOccurrenceOfAnElement {
//	Time complexity: O(N) and auxiliary space: O(1)
	public static int lastOccurrence(int arr[], int n, int x) {
		int ans = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				ans = i;
			}
		}
		return ans;
	}

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

//	Time complexity: O(LogN) and auxiliary space: O(LogN)
	public static int lastOccurrRec(int arr[], int lo, int hi, int key) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		if (arr[mid] < key) {
			lo = mid + 1;
		} else if (arr[mid] > key) {
			hi = mid - 1;
		} else {
			if (mid == 0 || arr[mid + 1] != arr[mid]) {
				return mid;
			}
			lo = mid + 1;
		}
		return lastOccurrRec(arr, lo, hi, key);
	}

	public static void main(String[] args) {
		int arr[] = { 5, 10, 10, 10, 10, 20, 20 }, n = 7;

		int x = 10;

		System.out.println(lastOccurrence(arr, n, x));
		System.out.println(lastOccurrence1(arr, n, x));
		System.out.println(lastOccurrRec(arr, 0, n - 1, x));
	}

}
