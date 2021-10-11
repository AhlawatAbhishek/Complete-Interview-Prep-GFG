package Tree;

import java.util.Stack;

public class IterativePreOrderBinaryTree {

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
		iterativePreOrder(root);
	}

//Time complexity : O(N) and space complexty : O(N) for stack
	public static void iterativePreOrder(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			Node curr = st.pop();
			System.out.println(curr.key + " ");
			if (curr.right != null) {
				st.push(curr.right);
			}
			if (curr.left != null) {
				st.push(curr.left);
			}

		}
	}

}
