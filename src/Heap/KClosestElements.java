package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Pair {
	Integer key;
	Integer value;

	public Pair(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}

public class KClosestElements {
//	Time complexity : O(N^2) and auxiliary space : O(1)
	public static void printKClosest(int arr[], int size, int k, int x) {
		boolean visited[] = new boolean[arr.length];
		for (int i = 0; i < k; i++) {
			int minDiff = Integer.MAX_VALUE;
			int minDiffIndex = 0;
			for (int j = 0; j < size; j++) {
				if (!visited[j] && Math.abs(x - arr[j]) <= minDiff) {
					minDiff = Math.abs(x - arr[j]);
					minDiffIndex = j;
				}
			}
			System.out.print(arr[minDiffIndex] + " ");
			visited[minDiffIndex] = true;
		}
	}

//	Time complexity : O(NLogn) and auxiliary space : O(N * 2)
	public static void printKClosest2(int arr[], int size, int k, int x) {
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int i : arr) {
			queue.offer(new int[] { Math.abs(x - i), i });
		}
		for (int i = 1; i <= k; i++) {
			System.out.print(queue.poll()[1] + " ");
		}
	}

//	Time complexity : O(N*Log k) and auxiliary space : O(N)
	public static void printKClosest3(int arr[], int n, int k, int x) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p2.getValue().compareTo(p1.getValue());
			}
		});

		for (int i = 0; i < k; i++) {
			pq.offer(new Pair(arr[i], Math.abs(arr[i] - x)));
		}

		for (int i = k; i < n; i++) {
			int diff = Math.abs(arr[i] - x);

			if (pq.peek().getValue() > diff) {
				pq.poll();
				pq.offer(new Pair(arr[i], diff));
			}
		}

		while (!pq.isEmpty()) {
			System.out.print(pq.poll().getKey() + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 30, 5, 40, 38, 80, 70 };

		int size = arr.length;

		int x = 35;
		int k = 3;

		printKClosest(arr, size, k, x);
		System.out.println();
		printKClosest2(arr, size, k, x);

	}

}
