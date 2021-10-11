package Sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 10, 8, 7 };
//		naiveSelectionSort(arr);
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

//time complexity : theta(n*n), space complexity : O(1);
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min_ind = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_ind]) {
					min_ind = j;
				}
			}
			swap(arr, min_ind, i);
		}
	}

	public static void swap(int arr[], int min_ind, int i) {
		int temp = arr[min_ind];
		arr[min_ind] = arr[i];
		arr[i] = temp;
	}

	public static void naiveSelectionSort(int arr[]) {
		int n = arr.length;
		int temp[] = new int[n];
		for (int i = 0; i < n; i++) {
			int min_ind = 0;
			for (int j = 1; j < n; j++) {
				if (arr[j] < arr[min_ind]) {
					min_ind = j;
				}
			}
			temp[i] = arr[min_ind];
			arr[min_ind] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = temp[i];
		}
	}

}
