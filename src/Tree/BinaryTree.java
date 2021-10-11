package Tree;

public class BinaryTree {
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
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		System.out.println("Height of tree is: " + height(root));

	}

//Time complexity : O(N) and space complexity : O(h) (h -> heigth of binary tree)
	static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}

	// Time complexity : O(N) and space complexity : O(h) (h -> heigth of binary
	// tree)
	static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.key + " ");
	}

	// Time complexity : O(N) and space complexity : O(h) (h -> heigth of binary
	// tree)
	static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	// Time complexity : O(N) and space complexity : O(h) (h -> heigth of binary
	// tree, h+1 call stack in worst case)
	static int height(Node root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}

}
