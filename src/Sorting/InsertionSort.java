package Sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 50, 40, 30, 20, 10 };
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

//Best Case time complexity : O(N) , Worst Case Time Complexity : theta(N*N)
//time Complexity for merge Sort is O(n*Log n) space Complexity = O(N)	
	public static void insertionSort(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];
			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}
}
