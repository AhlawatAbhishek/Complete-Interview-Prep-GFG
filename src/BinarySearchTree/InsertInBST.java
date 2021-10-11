package BinarySearchTree;

import java.util.Stack;

public class InsertInBST {

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
		Node root = new Node(15);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.right = new Node(20);
		root.right.left = new Node(18);
		root.right.left.left = new Node(16);
		root.right.right = new Node(80);
		Node rootNode = insertRecur(root, 100);
		Node rootN = insertIter(rootNode, 90);
		iterativeInOrder(rootN);

	}

	// Time complexity : O(logN) and space complexty : O(h) for stack
	public static Node insertRecur(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (root.key < key) {
			root.right = insertRecur(root.right, key);
		} else if (root.key > key) {
			root.left = insertRecur(root.left, key);
		}
		return root;
	}

	// Time complexity : O(logN) and space complexty : O(1)
	public static Node insertIter(Node root, int key) {
		Node parent = null, curr = root, newNode = new Node(key);
		while (curr != null) {
			parent = curr;
			if (curr.key < key) {
				curr = curr.right;
			} else if (curr.key > key) {
				curr = curr.left;
			} else {
				return root;
			}
		}
		if (parent == null) {
			return newNode;
		}

		if (parent.key < key) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		return root;
	}

	public static void iterativeInOrder(Node root) {
		Stack<Node> st = new Stack<>();
		Node curr = root;
		while (curr != null || !st.isEmpty()) {
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			curr = st.pop();
			System.out.print(curr.key + " ");
			curr = curr.right;
		}
	}

}
