package Sorting;

//time complexity : theta(n+k) and space complexity : theta(n+k)
import java.util.Arrays;

public class CountSort {
//elements are in range from 0 to k-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 4, 4, 1, 0, 1 };
		int n = arr.length;
		int k = 5;
//		naiveCountSort(arr, n, k);
		countSort(arr, n, k);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static void naiveCountSort(int arr[], int n, int k) {
		int[] count = new int[k];
//    	for(int i = 0; i<k; i++) {
//    		count[i] = 0;
//    	}
		Arrays.fill(count, 0);
		for (int i = 0; i < n; i++) {
			count[arr[i]]++;
		}
		int index = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < count[i]; j++) {
				arr[index] = i;
				index++;
			}
		}
	}

	public static void countSort(int arr[], int n, int k) {
		int count[] = new int[k];
		Arrays.fill(count, 0);
		for (int i = 0; i < n; i++) {
			count[arr[i]]++;
		}
		for (int i = 1; i < k; i++) {
			count[i] = count[i - 1] + count[i];
		}
		int output[] = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}
}
