package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInWindowOFSizeK {
//	Time complexity : O((n-k) * k * k) and auxiliary space : 0(1)
	public static void printDistinct(int arr[], int n, int k) {
		for (int i = 0; i <= n - k; i++) {
			int count = 0;
			for (int j = 0; j < k; j++) {
				boolean flag = false;
				for (int p = 0; p < j; p++) {
					if (arr[i + j] == arr[i + p]) {
						flag = true;
					}
				}
				if (!flag) {
					count++;
				}
			}
			System.out.print(count + " ");
		}
	}

//	Time complexity : O(n) and auxiliary space : O(K)
	public static void printDistinct2(int arr[], int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		System.out.print(map.size() + " ");
		for (int i = k; i < n; i++) {
			map.put(arr[i - k], map.get(arr[i - k]) - 1);
			if (map.get(arr[i - k]) == 0) {
				map.remove(arr[i - k]);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			System.out.print(map.size() + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 10, 5, 3, 20, 5 };

		int n = arr.length;
		int k = 4;
		printDistinct2(arr, n, k);
	}

}
