package Searching;

public class TripletWithGivenSum {
//	Time complexity: O(N^2) and auxiliary space: O(1)
	public static boolean find3Numbers(int arr[], int n, int target) {
		quickSort(arr, 0, n - 1);
		for (int i = 0; i < n; i++) {
			int l = i + 1, r = n - 1;
			while (l < r) {
				int sum = arr[i] + arr[l] + arr[r];
				if (sum == target) {
					System.out.println(arr[i] + " " + arr[l] + " " + arr[r]);
					return true;
				} else if (sum > target) {
					r--;
				} else {
					l++;
				}
			}
		}
		return false;
	}

	public static void quickSort(int arr[], int l, int r) {
		if (l < r) {
			int p = lomutoPartition(arr, l, r);
			quickSort(arr, l, p - 1);
			quickSort(arr, p + 1, r);
		}
	}

	public static int lomutoPartition(int arr[], int l, int r) {
		int index = l - 1, pivot = arr[r];
		for (int i = l; i < r; i++) {
			if (arr[i] < pivot) {
				index++;
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[index + 1];
		arr[index + 1] = arr[r];
		arr[r] = temp;
		return index + 1;
	}

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int sum = 22;
		int arr_size = A.length;
		System.out.println(find3Numbers(A, arr_size, sum));
	}

}
