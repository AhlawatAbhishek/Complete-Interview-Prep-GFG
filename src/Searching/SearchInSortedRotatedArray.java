package Searching;

public class SearchInSortedRotatedArray {
	public static void main(String[] args) {
		int arr[] = { 100, 200, 400, 1000, 10, 20 }, n = 6;

		int x = 10;

		System.out.println(search(arr, n, x));
		System.out.println(search1(arr, n, x));
	}

//	Time complexity: O(Log(N)) and auxiliary space: O(1)
	public static int search1(int arr[], int n, int key) {
		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[lo] < arr[mid]) {
				if (key >= arr[lo] && arr[mid] > key) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (key <= arr[hi] && arr[mid] < key) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}

//	Time complexity: O(N) and auxiliary space: O(1)
	public static int search(int arr[], int n, int key) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
}
