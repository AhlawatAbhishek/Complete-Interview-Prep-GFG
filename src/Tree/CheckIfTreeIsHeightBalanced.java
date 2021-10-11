package Tree;

public class CheckIfTreeIsHeightBalanced {

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
//		Node root = new Node(10);
//		root.left = new Node(20);
//		root.right = new Node(30);
//		root.left.left = new Node(40);
//		root.left.right = new Node(50);
//		root.right.left = new Node(60);
//		root.right.right = new Node(70);
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(30);
		root.right.left = new Node(15);
		root.right.right = new Node(20);
		System.out.println(checkIfBalanced(root));
		System.out.println(isBalanced(root));
	}

	public static int findHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(findHeight(root.left), findHeight(root.right));
	}

//Time complexity: O(n^2) and space complexity or auxiliary space: O(h / logn) for recursion stack
	public static boolean checkIfBalanced(Node root) {
		if (root == null) {
			return true;
		}
		return findHeight(root.left) - findHeight(root.right) <= 1 && checkIfBalanced(root.left)
				&& checkIfBalanced(root.right);
	}

	public static boolean isBalanced(Node root) {
		return checkBalancedEfficient(root) != -1;
	}

//	Time complexity: O(1) and space complexity or auxiliary space: O(heigh of binary tree or logn)
	public static int checkBalancedEfficient(Node root) {
		if (root == null) {
			return 0;
		}
		int lh = checkBalancedEfficient(root.left);
		if (lh == -1) {
			return -1;
		}
		int rh = checkBalancedEfficient(root.right);
		if (rh == -1) {
			return -1;
		}
		if (Math.abs(lh - rh) > 1) {
			return -1;
		} else {
			return 1 + Math.max(lh, rh);
		}
	}
}
