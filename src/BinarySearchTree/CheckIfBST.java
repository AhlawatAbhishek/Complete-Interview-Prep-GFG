package BinarySearchTree;

public class CheckIfBST {
	static int prev = Integer.MIN_VALUE;

	static class Node {
		int key;
		Node left;
		Node right;

		Node(int k) {
			key = k;
			left = right = null;
		}
	}

	public static int findMax(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int res = root.key;
		int left = findMax(root.left);
		int right = findMax(root.right);
		return Math.max(res, Math.max(left, right));
	}

	public static int findMin(Node root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int res = root.key;
		int left = findMin(root.left);
		int right = findMin(root.right);
		return Math.min(res, Math.min(left, right));
	}

//Time complexity: O(n^2) and space complexity: O(h^2) for recursion stack
	public static boolean isBST(Node root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (root.left != null && findMax(root.left) > root.key) {
			return false;
		}
		if (root.right != null && findMin(root.right) < root.key) {
			return false;
		}
		return isBST(root.left) && isBST(root.right);
	}

	// Time complexity: O(n) and space complexity: O(h/ logn) for recursion stack
	public static boolean isBSTEff2(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		return root.key > min && root.key < max && isBSTEff2(root.left, min, root.key)
				&& isBSTEff2(root.right, root.key, max);
	}

	// Time complexity: O(n) and space complexity: O(h/ logn) for recursion stack
	public static boolean isBSTEff3(Node root) {
		if (root == null) {
			return true;
		}
		if (!isBSTEff3(root.left))
			return false;
		if (root.key <= prev) {
			return false;
		}
		prev = root.key;
		return isBSTEff3(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		if (isBST(root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");

		if (isBSTEff2(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");

		prev = Integer.MIN_VALUE;
		if (isBSTEff3(root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}

}
