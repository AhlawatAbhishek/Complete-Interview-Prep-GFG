package Sorting;

public class SortAnArrayWIthTwoTypesOfElements {
//	Time complexity: O(N) and auxiliary space: O(N)
	public static void sort(int arr[], int n) {
		int indx = 0, temp[] = new int[n];
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				temp[indx++] = arr[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] >= 0) {
				temp[indx++] = arr[i];
			}
		}
		for (int i = 0; i < n; i++) {
			arr[i] = temp[i];
		}
	}

//	Time complexity: O(N) and auxiliary space: O(1)
	public static void sort1(int arr[], int n) {
		int i = 0, j = n - 1;
		while (true) {
			while (arr[i] < 0) {
				i++;
			}
			while (arr[j] >= 0) {
				j--;
			}
			if (i >= j) {
				return;
			}
			swap(arr, i, j);
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 13, -12, 18, -10 };

		int n = arr.length;

		sort(arr, n);

		for (int x : arr)
			System.out.print(x + " ");
	}

}
