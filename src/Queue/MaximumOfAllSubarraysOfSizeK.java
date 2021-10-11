package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumOfAllSubarraysOfSizeK {
//	Time complexity : O(n^2) and auxiliary space: O(1) 
	public static void printMax(int arr[], int n, int k) {
		for (int i = 0; i < n - k + 1; i++) {
			int max = arr[i];
			for (int j = i + 1; j < i + k; j++) {
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			System.out.print(max + " ");

		}
	}

//	Time complexity : O(n) and auxiliary space: O(n) 
	public static void printMax2(int arr[], int n, int k) {
		Deque<Integer> deq = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			while (!deq.isEmpty() && arr[deq.peekLast()] <= arr[i]) {
				deq.removeLast();
			}
			deq.addLast(arr[i]);
		}
		for (int i = k; i < n; i++) {
			System.out.print(deq.peek() + " ");
			while (!deq.isEmpty() && deq.peekFirst() <= i - k) {
				deq.removeFirst();
			}
			while (!deq.isEmpty() && deq.peekLast() <= arr[i]) {
				deq.removeLast();
			}
			deq.addLast(arr[i]);
		}
		System.out.print(deq.peek() + " ");
	}

	public static void main(String[] args) {
		int arr[] = { 20, 40, 30, 10, 60 };
		int k = 3;
		printMax2(arr, arr.length, k);

	}

}
