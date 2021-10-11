package Sorting;

public class HoaresPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 3, 8, 4, 2, 7, 1, 10 };
		int n = arr.length;
		partition(arr, 0, n - 1);
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}

	public static int partition(int arr[], int l, int h) {
		int pivot = arr[l];
		int i = l - 1, j = h + 1;
		while (true) {
			do {
				i++;
			} while (arr[i] < pivot);
			do {
				j--;
			} while (arr[j] > pivot);
			if (i >= j) {
				return j;
			}
			swap(arr, i, j);
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
