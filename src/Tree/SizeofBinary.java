package Tree;

public class SizeofBinary {
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
		System.out.println(size(root));
	}

//Time complexity : O(N) and space complexty : O(h), h = height of binary tree
//	There can an iterative solution also in which level order traversal will be used,
//	Time complexity : O(N) and space complexity is O(W), w is width of binary tree;
	public static int size(Node root) {
		if (root == null) {
			return 0;
		}
		return size(root.left) + size(root.right) + 1;
	}
}
