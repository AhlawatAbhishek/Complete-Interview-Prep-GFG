package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortKSortedArray {
//	K sorted means an element at index i is present between i -k and i + k indicies in the sorted array
//	Time complexity : O((n+k) * logk) and auxiliary space : O(k) 
//	takes O(n log k) time and uses O(k) auxiliary space.
	public static void sortK(int arr[], int n, int k) {
		Queue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i <= k; i++) {
			queue.offer(arr[i]);
		}
		int index = 0;
		for (int i = k + 1; i < n; i++) {
			arr[index++] = queue.poll();
			queue.offer(arr[i]);
		}
		while (!queue.isEmpty()) {
			arr[index++] = queue.poll();
		}
	}

	public static void printArray(int arr[], int n) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		int n = arr.length;
		sortK(arr, n, k);
		System.out.println("Following is sorted array");
		printArray(arr, n);

	}

}
