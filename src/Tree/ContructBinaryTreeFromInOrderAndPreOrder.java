package Tree;

public class ContructBinaryTreeFromInOrderAndPreOrder {
	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	static int preIndex = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[] = { 20, 10, 40, 30, 50 };
		int pre[] = { 10, 20, 30, 40, 50 };
		int n = in.length;
		Node root = cTree(in, pre, 0, n - 1);

		inorder(root);
	}

//Time complexity : O(n^2), if use hashing this becomes O(n), space complexity : O(height)
	public static Node cTree(int in[], int[] pre, int si, int ei) {
		if (si > ei) {
			return null;
		}
		Node root = new Node(pre[preIndex++]);
		int inIndex = -1;
		for (int i = 0; i < in.length; i++) {
			if (pre[preIndex - 1] == in[i]) {
				inIndex = i;
			}
		}
		root.left = cTree(in, pre, si, inIndex - 1);
		root.right = cTree(in, pre, inIndex + 1, ei);
		return root;
	}

	public static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}
