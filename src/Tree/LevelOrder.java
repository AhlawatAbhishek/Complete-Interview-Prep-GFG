package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	static class Node {
		int key;
		Node left;
		Node right;

		Node(int k) {
			key = k;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		levelOrder(root);
	}

//Time complexity : Theta(N) and Space complexity(auxillary space:) O(n) // theta(w), w is width of binary tree.
	static void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.print(n.key + " ");
			if (n.left != null) {
				queue.offer(n.left);
			}
			if (n.right != null) {
				queue.offer(n.right);
			}
		}

	}
}
