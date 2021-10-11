package Tree;

import java.util.Stack;

public class IterativeInOrderBinaryTree {

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
		iterativeInOrder(root);
	}

//Time complexity : O(N) and space complexty : O(h), h = height of binary tree
	public static void iterativeInOrder(Node root) {
		Stack<Node> st = new Stack<>();
		Node curr = root;
		while (curr != null || !st.isEmpty()) {
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			curr = st.pop();
			System.out.println(curr.key + " ");
			curr = curr.right;
		}
	}

}
