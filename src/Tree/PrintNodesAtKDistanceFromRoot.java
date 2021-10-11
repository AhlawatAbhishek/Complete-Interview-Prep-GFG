package Tree;

public class PrintNodesAtKDistanceFromRoot {

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
		int k = 2;
		kthNode(root, k);
	}

	// Time complexity : O(N) and space complexity : O(h) (h -> heigth of binary
	// tree, h+1 call stack in worst case)
	static void kthNode(Node root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.println(root.key + " ");
		} else {
			kthNode(root.left, k - 1);
			kthNode(root.right, k - 1);
		}
	}

}
