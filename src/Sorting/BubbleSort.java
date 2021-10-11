package Sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 10, 8, 7 };
//		bubbleSort(arr);
		bubbleSortImproved(arr);
		System.out.println(Arrays.toString(arr));
	}

//Time Complexity : theta(n*n) and space complexity(Auxillary space) : O(1)
	public static void bubbleSort(int arr[]) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - counter - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void bubbleSortImproved(int arr[]) {

		for (int counter = 0; counter < arr.length - 1; counter++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - counter - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false) {
				break;
			}
		}
	}
}
