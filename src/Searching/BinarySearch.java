package Searching;

public class BinarySearch {
//Array is already sorted
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 10 };
//		{10, 15} {10, 15} { 10, 20, 30, 40, 50, 60 } {10, 10}
		System.out.println(binarySearch(arr, 10));
	}

	// Time Complexity : successful search : O(logn) and unsuccessful search :
	// theta(logn) , Space Complexity : O(logn)
	private static int binarySearch(int[] arr, int ele) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (arr[mid] < ele) {
				low = mid + 1;
			} else if (arr[mid] > ele) {
				high = mid - 1;
			} else if (arr[mid] == ele) {
				return mid;
			}
		}
		return -1;
	}
}
