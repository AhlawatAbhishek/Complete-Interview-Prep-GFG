package Sorting;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 50, 40, 30, 20, 10 };
		shellSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	public static void shellSort(int arr[], int n) {
		// code here
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}
	}
}
