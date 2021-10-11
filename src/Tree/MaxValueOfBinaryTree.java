package Tree;

public class MaxValueOfBinaryTree {
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
		System.out.println(maxValue(root));
	}

//Time complexity : O(N) and space complexty : O(h), h = height of binary tree
//	There can an iterative solution also in which level order traversal will be used,
//	Time complexity : O(N) and space complexity is O(W), w is width of binary tree;
	public static int maxValue(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int maxRes = Math.max(maxValue(root.left), maxValue(root.right));
		return Math.max(root.key, maxRes);
	}
}
