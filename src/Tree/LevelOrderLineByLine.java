package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine {
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

		printLevelNaive(root);
		System.out.println();
		printLevelMethod2(root);
	}

//Time complexity : O(n) and space complexity : O(n) or 0(width of tree = n(in worst 
//	case))
	public static void printLevelNaive(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		while (queue.size() > 1) {
			Node node = queue.poll();
			if (node == null) {
				System.out.println();
				queue.add(null);
				continue;
			}
			System.out.print(node.data + " ");
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}

		}
	}

	// Time complexity : O(n) and space complexity : O(n) or 0(width of tree = n(in
	// worst
//	case))
	public static void printLevelMethod2(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Node node = queue.poll();
				System.out.print(node.data + " ");
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			System.out.println();
		}
	}
}
