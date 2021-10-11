package BinarySearchTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
	static class Pair {
		Node root;
		int hd;

		Pair(Node r, int d) {
			this.root = r;
			this.hd = d;
		}
	}

	static class Node {
		int key;
		Node left;
		Node right;

		Node(int k) {
			key = k;
			left = right = null;
		}
	}

	// Time complexity : O(N) and space complexity or auxiliary space: O(N)
	public static void topView(Node root) {
		if (root == null) {
			return;
		}
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(root, 0));
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Pair p = queue.poll();
				Node n = p.root;
				int hd = p.hd;
				if (!map.containsKey(hd)) {
					map.put(hd, n.key);
				}
				if (n.left != null) {
					queue.offer(new Pair(n.left, hd - 1));
				}
				if (n.right != null) {
					queue.offer(new Pair(n.right, hd + 1));
				}
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);

		topView(root);
	}

}
