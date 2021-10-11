package Sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = { 10, 15, 20, 40 };
		int arr2[] = { 5, 6, 6, 10, 15 };
//		int arr[] = mergeTwoSortedArrays(arr1, arr2);
		mergeTwoSortedArraysNaive(arr1, arr2, arr1.length, arr2.length);
//		System.out.println(Arrays.toString(arr));
	}

// time complexity : O(m+n) and space Complexity O(n+m)
	public static int[] mergeTwoSortedArrays(int arr1[], int arr2[]) {
		int arr[] = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				k++;
				i++;
			} else {
				arr[k] = arr2[j];
				k++;
				j++;
			}
		}
		if (i < arr1.length) {
			while (arr1.length > i) {
				arr[k] = arr1[i];
				i++;
				k++;
			}
		}
		if (j < arr2.length) {
			while (arr2.length > j) {
				arr[k] = arr1[j];
				j++;
				k++;
			}
		}
		return arr;
	}

//time complexity O((m+n) log(m+n))
	public static void mergeTwoSortedArraysNaive(int arr1[], int arr2[], int m, int n) {
		int c[] = new int[m + n];
		for (int i = 0; i < m; i++) {
			c[i] = arr1[i];
		}
		for (int i = 0; i < n; i++) {
			c[i + m] = arr2[i];
		}
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
	}
}
