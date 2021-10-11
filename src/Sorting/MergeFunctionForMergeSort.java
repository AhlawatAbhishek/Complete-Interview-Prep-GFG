package Sorting;

import java.util.Arrays;

public class MergeFunctionForMergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 15, 20, 40, 8, 11, 15, 22, 25 };
		int l = 0, h = 8, m = 3;
//		int ar[] = sort(arr, l, h, m);
		merge(arr, l, m, h);
//		System.out.println(Arrays.toString(ar));
		System.out.println(Arrays.toString(arr));
	}

	public static void merge(int arr[], int l, int m, int h) {
		int n1 = m - l + 1;
		int n2 = h - m;
		int left[] = new int[n1], right[] = new int[n2];
		for (int i = 0; i < n1; i++) {
			left[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			right[j] = arr[m + 1 + j];
		}
		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		while (i < n1) {
			arr[k++] = left[i++];
		}
		while (j < n2) {
			arr[k++] = right[j++];
		}
	}

	public static int[] sort(int arr1[], int l, int h, int m) {
		int arr[] = new int[arr1.length];
		int i = 0, j = m + 1, k = 0;
		while (i <= m && j <= h) {
			if (arr1[i] < arr1[j]) {
				arr[k] = arr1[i];
				k++;
				i++;
			} else {
				arr[k] = arr1[j];
				k++;
				j++;
			}
		}
		if (i <= m) {
			while (m >= i) {
				arr[k] = arr1[i];
				i++;
				k++;
			}
		}
		if (j <= h) {
			while (h >= j) {
				arr[k] = arr1[j];
				j++;
				k++;
			}
		}
		return arr;
	}

}
