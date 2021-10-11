package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
	static int maxLevel = 0;

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		printLeftView(root);
		System.out.println();
		printLeftViewRecur(root, 1);
	}

	// Time complexity : O(n) and space complexity : O(height of tree = logn(in
	// worst
//		case)) for recursion stack
	public static void printLeftViewRecur(Node root, int level) {
		if (root == null) {
			return;
		}
		if (maxLevel < level) {
			System.out.print(root.data + " ");
			maxLevel = level;
		}
		printLeftViewRecur(root.left, level + 1);
		printLeftViewRecur(root.right, level + 1);
	}

	// Time complexity : O(n) and space complexity : O(n) or 0(width of tree = n(in
	// worst
//		case))
	public static void printLeftView(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int temp = size;
			while (size > 0) {
				Node node = queue.poll();
				if (temp == size)
					System.out.print(node.data + " ");
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				size--;
			}
		}
	}
}
