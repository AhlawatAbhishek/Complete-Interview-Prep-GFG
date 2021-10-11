package Sorting;

public class LomutoPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 10, 80, 30, 90, 40, 50, 70 };
		int n = arr.length;
		int res = lomutoPartition(arr, 0, arr.length - 1);
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("the length of smaller segment than pivot is: " + res);
	}

	public static int lomutoPartition(int arr[], int l, int h) {
		int pivot = arr[h];
		int i = l - 1;
		for (int j = l; j <= h; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[h];
		arr[h] = temp;
		return i + 1;
	}
}
