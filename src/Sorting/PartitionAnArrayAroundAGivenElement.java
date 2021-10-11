package Sorting;

public class PartitionAnArrayAroundAGivenElement {

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 13, 6, 9, 12, 11, 8 };
		int n = arr.length;
		partition(arr, 0, n - 1, n - 1);
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}

//time complexity : O(n) and space complexity (auxillary space : O(n)) : O(n) 
	public static void partition(int arr[], int l, int h, int p/* index of last element */) {
		int temp[] = new int[h - l + 1];
		int index = 0;
		for (int i = l; i <= h; i++) {
			if (arr[i] <= arr[p]) {
				temp[index] = arr[i];
				index++;
			}
		}
		for (int i = l; i <= h; i++) {
			if (arr[i] > arr[p]) {
				temp[index] = arr[i];
				index++;
			}
		}
		for (int i = l; i <= h; i++) {
			arr[i] = temp[i - l];
		}
		for (int i = l; i <= h; i++) {
			arr[i] = temp[i - l];
		}
	}
}
