package Sorting;

//Time Complexity theta(d*(n+b)) and Extra Space theta(n+b)
public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 319, 212, 6, 8, 100, 50 };
		int n = arr.length;
		radixSort(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void countingSort(int arr[], int n, int exp) {
		int[] output = new int[n];
		int[] count = new int[10];
		for (int i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

	public static void radixSort(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > mx) {
				mx = arr[i];
			}
		}
		for (int exp = 1; mx / exp > 0; exp *= 10) {
			countingSort(arr, n, exp);
		}
	}
}
