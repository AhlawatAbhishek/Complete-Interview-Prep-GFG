package Sorting;

import java.util.Arrays;
import java.util.Random;

public class KthSmallest {
//	returns  kThSmallestElement
//	Time complexity: O(NLogN) and auxiliary space: O(1)
	public static int kthSmallest(int arr[], int n, int k) {
		Arrays.sort(arr);
		return arr[k - 1];
	}

//	Time complexity: O(N^2) in worst case, O(N) in average case and auxiliary space: O(1)
	public static int kthSmallest1(int arr[], int l, int r, int k) {
		int ans = Integer.MAX_VALUE;
		while (l <= r) {
			int p = lomutoPartition(arr, l, r);
			if (k - 1 < p) {
				r = p - 1;
			} else if (k - 1 > p) {
				l = p + 1;
			} else {
				ans = arr[p];
				break;
			}
		}
		return ans;
	}

	static void swap(int arr[], int l, int r) {
		int tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
	}

	public static void generatePivot(int arr[], int l, int r) {
		int n = r - l + 1;
		Random ran = new Random();
		int pivot = ran.nextInt(n);
		swap(arr, l + pivot, r);
	}

	public static int lomutoPartition(int arr[], int l, int r) {
		generatePivot(arr, l, r);
		int pivot = arr[r], i = l - 1;
		for (int j = l; j < r; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[r];
		arr[r] = temp;
		return i + 1;
	}

// Median Order Statistics Algo does this job in O(N) in worst case;
	public static void main(String[] args) {
		int arr[] = new int[] { 10, 5, 30, 12 };

		int n = arr.length;
		int k = 2;
		System.out.println(kthSmallest1(arr, 0, n - 1, k));
		System.out.print(kthSmallest(arr, n, k));
	}

}
