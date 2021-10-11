package BinarySearchTree;

public class FloorInBst {

	static class Node {
		Node left, right;
		int key;

		Node(int key) {
			left = null;
			right = null;
			this.key = key;
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
		int x = 17;
		System.out.println("Floor: " + floor(root, x).key);
	}

//time complexity : O(h), h = height of binary tree = logn and space complexity O(1);
	public static Node floor(Node root, int x) {
		Node res = null;
		while (root != null) {
			if (root.key == x) {
				return root;
			} else if (root.key > x) {
				root = root.left;
			} else {
				res = root;
				root = root.right;
			}
		}
		return res;
	}

}
