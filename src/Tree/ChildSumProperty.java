package Tree;

public class ChildSumProperty {
//sum of values of child nodes = value of their parent for the whole tree
	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(12);
		root.right.left = new Node(3);
		root.right.right = new Node(9);
		System.out.print(isCSum(root));
	}

//Time complexity: O(n) and space complexity or auxiliary space: O(height of binary tree
//	-log(n))
	public static boolean isCSum(Node root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		int sum = 0;
		if (root.left != null)
			sum += root.left.data;
		if (root.right != null)
			sum += root.right.data;
		return (sum == root.data) && isCSum(root.left) && isCSum(root.right);
	}

}
