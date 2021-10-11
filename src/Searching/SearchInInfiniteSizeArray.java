package Searching;

public class SearchInInfiniteSizeArray {
//pos - location / index of element if present
//	Time complexity: O(pos) and auxiliary space: O(1)

	public static int search(int arr[], int x) {
		int index = 0;
		while (true) {
			if (arr[index] == x)
				return index;
			if (arr[index] > x)
				return -1;
			index++;
		}
	}
//Unbounded binary search
//	Time complexity: O(Log(pos)) and auxiliary space: O(1)

	public static int search1(int arr[], int x) {
		if (arr[0] == x) {
			return 0;
		}
		int index = 1;
		while (arr[index] < x) {
			index *= 2;
		}
		if (arr[index] == x)
			return index;
		return binarySearch(arr, index / 2 + 1, index = 1, x);
	}

	public static int binarySearch(int arr[], int lo, int hi, int key) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] < key) {
				lo = mid + 1;
			} else if (arr[mid] > key) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 5, 5 };

		int x = 4;
		System.out.println(search1(arr, x));
		System.out.println(search(arr, x));

	}

}
