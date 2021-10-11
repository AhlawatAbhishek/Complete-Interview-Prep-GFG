package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalInSpiralForm {
	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printSpiral(root);
		System.out.println("--------------------");
		printSpiralEfficient(root);
	}

	// Time complexity : O(n) and space complexity: O(n)
	public static void printSpiralEfficient(Node root) {
		Stack<Node> primary = new Stack<>();
		Stack<Node> secondary = new Stack<>();
		primary.push(root);
		while (!primary.isEmpty() || !secondary.isEmpty()) {
			if (!primary.isEmpty()) {
				int size = primary.size();
				while (size-- > 0) {
					Node node = primary.pop();
					System.out.print(node.data + " ");
					if (node.left != null) {
						secondary.push(node.left);
					}
					if (node.right != null) {
						secondary.push(node.right);
					}
				}
				System.out.println();
			} else if (!secondary.isEmpty()) {
				int size = secondary.size();
				while (size-- > 0) {
					Node node = secondary.pop();
					System.out.print(node.data + " ");
					if (node.right != null) {
						primary.push(node.right);
					}
					if (node.left != null) {
						primary.push(node.left);
					}
				}
				System.out.println();
			}
		}
	}

//Time complexity : O(n) and space complexity: O(n)
	public static void printSpiral(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			ArrayList<Integer> al = new ArrayList<>();
			int size = queue.size();
			while (size-- > 0) {
				Node n = queue.poll();
				al.add(n.data);
				if (n.left != null) {
					queue.offer(n.left);
				}
				if (n.right != null) {
					queue.offer(n.right);
				}
			}
			if (leftToRight) {
				for (int i : al) {
					System.out.print(i + " ");
				}
				leftToRight = !leftToRight;
			} else {
				for (int i = al.size() - 1; i >= 0; i--) {
					System.out.print(al.get(i) + " ");
				}
				leftToRight = !leftToRight;
			}
			System.out.println();
		}
	}
}
