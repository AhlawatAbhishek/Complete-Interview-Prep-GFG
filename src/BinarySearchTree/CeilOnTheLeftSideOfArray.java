package BinarySearchTree;

import java.util.TreeSet;

public class CeilOnTheLeftSideOfArray {

	public static void main(String[] args) {
		int arr[] = { 2, 8, 30, 15, 25, 12 };
		int n = arr.length;

		printCeiling(arr, n);
		System.out.println();
		printCeilingEfficient(arr, n);
	}

////	Time complexity: O(h/logn) and space complexity : auxiliary : O(1) 
	public static void printCeiling(int arr[], int n) {
		for (int i = 0; i < arr.length; i++) {
			int diff = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] >= arr[i]) {
					diff = Math.min(arr[j] - arr[i], diff);
				}
			}
			if (diff == Integer.MAX_VALUE) {
				System.out.print("-1 ");
			} else {
				System.out.print(arr[i] + diff + " ");
			}
		}
	}

//	Time complexity: O(nlogn) and space complexity : auxiliary : O(N) 
	public static void printCeilingEfficient(int arr[], int n) {
		TreeSet<Integer> tSet = new TreeSet<>();
//	O(n)
		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];
//			O(logn)
			if (tSet.ceiling(x) != null) {
				System.out.print(tSet.ceiling(x) + " ");
			} else {
				System.out.print(-1 + " ");
			}
			tSet.add(x);
		}
	}
}
