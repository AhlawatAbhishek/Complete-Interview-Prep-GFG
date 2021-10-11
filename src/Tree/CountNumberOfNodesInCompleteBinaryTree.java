package Tree;

public class CountNumberOfNodesInCompleteBinaryTree {
//	int res = 0;

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
		root.right.right = new Node(50);
//		CountNumberOfNodesInCompleteBinaryTree cObj = new CountNumberOfNodesInCompleteBinaryTree();  
		System.out.println(countNode(root));
		System.out.println(countNodesEfficient(root));
	}

//Time complexity : O(logn * logn) and space complexity : O(h/logn)
	public static int countNodesEfficient(Node root) {
		int lh = 0, rh = 0;
		Node curr = root;
		while (curr != null) {
			lh++;
			curr = curr.left;
		}
		curr = root;
		while (curr != null) {
			rh++;
			curr = curr.right;
		}
		if (lh == rh) {
			return (int) Math.pow(2, lh) - 1;
		} else {
			return countNodesEfficient(root.left) + countNodesEfficient(root.right) + 1;
		}
	}

//Time complexity : O(n) and space complexity or auxiliary space : O(h/ logn) for recursion stack
	public static int countNode(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNode(root.left) + countNode(root.right);
	}
}
