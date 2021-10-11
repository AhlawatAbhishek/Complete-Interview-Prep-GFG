package Searching;

public class RecursiveBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 20, 30, 40, 50, 60 };
		System.out.println(recurBinarySearch(arr, 90, 0, arr.length - 1));
	}

//Time Complexity : successful search  : O(logn) and unsuccessful search : theta(logn) , Space Complexity : O(logn)
	private static int recurBinarySearch(int arr[], int ele, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + ((hi - lo) / 2);
		int ans = -1;
		if (arr[mid] < ele) {
			ans = recurBinarySearch(arr, ele, mid + 1, hi);
		} else if (arr[mid] > ele) {
			ans = recurBinarySearch(arr, ele, lo, mid - 1);
		} else if (arr[mid] == ele) {
			ans = mid;
		}
		return ans;
	}

}
