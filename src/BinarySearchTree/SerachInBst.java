package BinarySearchTree;

public class SerachInBst {

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
		int x = 100;

		if (searchRecur(root, x)) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}

		int y = 16;
		if (searchIter(root, x)) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}
	}

//Time complexity : O(logN) and space complexty : O(h) for stack
	public static boolean searchRecur(Node root, int key) {
		if (root == null) {
			return false;
		}
		if (root.key == key) {
			return true;
		} else if (root.key < key) {
			root = root.right;
			return searchRecur(root, key);
		} else {
			root = root.left;
			return searchRecur(root, key);
		}
	}

	// Time complexity : O(logN) and space complexty : O(logN) or O(h) , h =
	// logN(balanced bst,
//	in case of unbalanced bst it can go to N)
	public static boolean searchIter(Node root, int key) {
		while (root != null) {
			if (root.key == key) {
				return true;
			} else if (root.key < key) {
				root = root.right;
			} else if (root.key > key) {
				root = root.left;
			}
		}
		return false;
	}

}
