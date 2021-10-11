package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayElementsWithMoreThanCertainNumberOfOccurences {
	// Time complexity : O(NLogN) and space complexity : O(1)
	public static void printNByK(int arr[], int n, int k) {
		Arrays.sort(arr);
		int i = 1;
		int count = 1;
		while (i < n) {
			while (i < n && arr[i] == arr[i - 1]) {
				i++;
				count++;
			}
			if (count > n / k) {
				System.out.print(arr[i - 1] + " ");
			}
			count = 1;
			i++;
		}
	}

//Time complexity : O(N) and space complexity : O(n)
	public static void printNByK2(int arr[], int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > n / k) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}

	// Time complexity : O(N*K) and space complexity : 0(k-1)
	public static void printNByK3(int arr[], int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			} else if (map.size() < k - 1) {
				map.put(i, 1);
			} else {
				for (Map.Entry e : map.entrySet()) {
					int val = (int) e.getValue() - 1;
					if (val == 0) {
						map.remove((int) e.getKey());
					} else {
						map.put((int) e.getKey(), val);
					}
				}
			}

		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int count = 0;
			for (int i : arr) {
				if (key == i) {
					count++;
				}
			}
			if (count > n / k) {
				System.out.print(key + " ");
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 10, 20, 30, 20, 10, 10 };
		int n = arr.length;
		int k = 2;
		printNByK3(arr, n, k);
	}

}
