package Tree;

public class DiameterOfBinaryTree {
	int ans = 0;

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.right.left = new Node(40);
		root.right.right = new Node(60);
		root.right.left.left = new Node(50);
		root.right.right.right = new Node(70);
		DiameterOfBinaryTree dobj = new DiameterOfBinaryTree();
		dobj.diameterOfTree(root);
		System.out.println(dobj.ans);
	}

	public static int height(Node root) {
		if (root == null)
			return 0;
		else
			return (1 + Math.max(height(root.left), height(root.right)));
	}

	// Time complexity : O(N^2) and space complexity: O(h^2 or logn^2)
	public static int diameterNaive(Node root) {
		if (root == null)
			return 0;
		int d1 = 1 + height(root.left) + height(root.right);
		int d2 = diameterNaive(root.left);
		int d3 = diameterNaive(root.right);

		return Math.max(d1, Math.max(d2, d3));
	}

//Time complexity : O(N) and space complexity: O(h or logn)
	public int diameterOfTree(Node root) {
		if (root == null) {
			return 0;
		}
		int leftLen = 0, rightLen = 0;
		if (root.left != null) {
			leftLen = diameterOfTree(root.left);
		}
		if (root.right != null) {
			rightLen = diameterOfTree(root.right);
		}
		int diaOfCurr = leftLen + rightLen + 1;
		ans = Math.max(ans, diaOfCurr);
		return Math.max(leftLen, rightLen) + 1;
	}
}
