package Searching;

import java.util.Arrays;

public class RepeatingELement {
//	Time complexity : O(N^2) and auxiliary space: O(1)
	public static int repeat(int arr[], int n) {
		int res = -1;
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count >= 2) {
				return arr[i];
			}
		}
		return res;
	}

//	Time complexity : O(NLogN) and auxiliary space: O(1)
	public static int repeat1(int arr[], int n) {
		Arrays.sort(arr);
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				return arr[i];
			}
		}
		return -1;
	}

//	Time complexity : O(NLogN) and auxiliary space: O(n)
	public static int repeat2(int arr[], int n) {
		boolean visited[] = new boolean[n - 1];
		for (int i = 0; i < arr.length; i++) {
			if (visited[arr[i]])
				return arr[i];
			visited[arr[i]] = true;
		}
		return -1;
	}

//	Time complexity : O(N) and auxiliary space: O(1)
	public static int repeat3(int arr[], int n) {
		int slow = arr[0] + 1, fast = slow;
		do {
			slow = arr[slow] + 1;
			fast = arr[arr[fast] + 1] + 1;
		} while (slow != fast);
		slow = arr[0] + 1;
		while (slow != fast) {
			slow = arr[slow] + 1;
			fast = arr[fast] + 1;
		}
		return slow - 1;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 2, 1, 3, 2, 2 }, n = 6;
		System.out.println(repeat1(arr, n));
		System.out.println(repeat2(arr, n));
		System.out.println(repeat3(arr, n));
		System.out.println(repeat(arr, n));

	}

}
