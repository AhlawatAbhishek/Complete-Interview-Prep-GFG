package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

class Node {
	double val;
	Node left, right;
	int lCount = 0;

	Node(double key) {
		val = key;
		left = right = null;
		lCount = 0;
	}
}

public class MedianOfAStream {
//	Time complexity : O(N^2) and auxiliary space : O(N)
	public static void printMediansOfStream(double arr[]) {
		int n = arr.length;
		int size = 0;
		double[] temp = new double[n];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i];
			size++;
			int j = i;
			while (j > 0 && temp[j - 1] > temp[j]) {
				double t = temp[j - 1];
				temp[j - 1] = temp[j];
				temp[j] = t;
			}
			if (size % 2 != 0) {
				System.out.println(temp[size / 2]);
			} else {
				double median = (temp[(size) / 2] + temp[(size - 1) / 2]) / 2;
				System.out.println(median);
			}

		}
	}

//Time complexity : O(h) and auxiliary space : O(h), h = log n
	public static Node insert(Node root, double val) {
		if (root == null) {
			return new Node(val);
		}
		if (val < root.val) {
			root.left = insert(root.left, val);
			root.lCount++;
		}
		if (val > root.val) {
			root.right = insert(root.right, val);
		}
		return root;
	}

//Time complexity : O(n*h), h = logn and auxiliary space : O(h)
	public static Node kThSmallest(Node root, int k) {
		if (root == null) {
			return null;
		}
		int l = root.lCount + 1;
		if (l == k) {
			return root;
		} else if (l < k) {
			return kThSmallest(root.right, k - l);
		} else {
			return kThSmallest(root.left, k);
		}
	}

//Time complexity : O(n * h) and auxiliary space: O(N);
	public static void printMedianOfStream2(double arr[]) {
		Node root = null;
		int size = 0;
		for (double i : arr) {
			root = insert(root, i);
			size++;
			if (size % 2 != 0) {
				System.out.println(kThSmallest(root, (size / 2) + 1).val);
			} else {
				System.out.println(((kThSmallest(root, (size / 2) + 1).val + kThSmallest(root, (size / 2)).val) / 2));
			}
		}
	}

//Time complexity : O(n*log n) and auxiliary space : O(N)
	public static void printMedianOfStream3(double arr[]) {
		Queue<Double> s = new PriorityQueue<>((a, b) -> (int) (b - a));
		Queue<Double> g = new PriorityQueue<>();
		s.offer(arr[0]);
		System.out.println(s.peek());

		for (int i = 1; i < arr.length; i++) {
			double x = arr[i];
			if (s.size() > g.size()) {
				if (x < s.peek()) {
					g.offer(s.poll());
					s.offer(x);
				} else {
					g.offer(x);
				}
				System.out.println((s.peek() + g.peek()) / 2);
			} else {
				if (x <= s.peek()) {
					s.offer(x);
				} else {
					g.offer(x);
					s.offer(g.poll());
					;
				}
				System.out.println(s.peek());
			}
		}
	}

	public static void main(String[] args) {
		double[] arr = new double[] { 25, 7, 10, 15, 20 };
		int n = 5;
//		printMediansOfStream(arr);
//		printMedianOfStream2(arr);
		printMedianOfStream3(arr);
	}

}
