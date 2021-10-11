package Searching;

public class CountNumberOfOnesInASortedArray {
//	Time complexity: O(N) and auxiliary space: O(1)
	public static int countOnes(int arr[], int n) {
		int count = 0;
		for (int i : arr) {
			if (i == 1) {
				count++;
			}
		}
		return count;
	}

//	Time complexity: O(LogN) and auxiliary space: O(1)
	public static int countOnes1(int arr[], int n) {
		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] > 1) {
				hi = mid - 1;
			} else if (arr[mid] < 1) {
				lo = mid + 1;
			} else {
				if (mid == 0 || arr[mid - 1] == 0) {
					return n - mid;
				}
				hi = mid - 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 0, 1, 1, 1, 1 }, n = 6;

		System.out.println(countOnes1(arr, n));
		System.out.println(countOnes(arr, n));
	}

}
