package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfABinaryTree {

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		System.out.println(findMaxWidth(root));
	}

//Time complexity : 0(n) and space complexity: 0(maxWidth) or O(n), as for a perfect binary tree
//	maxWidth = n/2
	public static int findMaxWidth(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int maxWidth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			maxWidth = Math.max(maxWidth, size);
			while (size-- > 0) {
				Node n = queue.poll();
				if (n.left != null) {
					queue.offer(n.left);
				}
				if (n.right != null) {
					queue.offer(n.right);
				}
			}
		}
		return maxWidth;
	}
}
