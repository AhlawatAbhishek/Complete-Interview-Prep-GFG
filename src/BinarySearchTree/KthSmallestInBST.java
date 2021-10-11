package BinarySearchTree;

public class KthSmallestInBST {
//	static int count = 0; // for naive method
	static class Node {
		int key;
		Node left;
		Node right;
// for efficent part lCount is included
		int lCount;

		Node(int k) {
			key = k;
			left = right = null;
			lCount = 0;
		}
	}

	public static Node insert(Node root, int x) {
		if (root == null)
			return new Node(x);

		if (x < root.key) {
			root.left = insert(root.left, x);
			root.lCount++;
		}

		else if (x > root.key)
			root.right = insert(root.right, x);
		return root;
	}

//	Efficient
//	Time complexity: O(h/ logn) and space complexity : O(h/logn) 
	public static Node kthSmallest(Node root, int k) {
		if (root == null)
			return null;

		int count = root.lCount + 1;
		if (count == k)
			return root;

		if (count > k)
			return kthSmallest(root.left, k);

		return kthSmallest(root.right, k - count);
	}

	public static void main(String args[]) {
		Node root = null;
		int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

		for (int x : keys)
			root = insert(root, x);

		int k = 4;
		Node res = kthSmallest(root, k);
		if (res == null)
			System.out.println("There are less " + "than k nodes in the BST");
		else
			System.out.println("K-th Smallest" + " Element is " + res.key);
	}
//	public static void main(String[] args) {
////		for naive method
////		count = 0;
////		Node root = new Node(15);
////		root.left = new Node(5);
////		root.left.left = new Node(3);
////		root.right = new Node(20);
////		root.right.left = new Node(18);
////		root.right.left.left = new Node(16);
////		root.right.right = new Node(80);
////		int k = 3;
////		System.out.print("Kth Smallest: ");
////		printKth(root, k);
//
////	for Efficient method
//		Node root = null;
//		int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
//
//		for (int x : keys)
//			root = insert(root, x);
//
//		int k = 4;
//		Node res = kthSmallest(root, k);
//		if (res == null)
//			System.out.println("There are less " + "than k nodes in the BST");
//		else
//			System.out.println("K-th Smallest" + " Element is " + res.key);
//	}
// Naive method
//	Time complexity: O(k) and space complexity : O(h/logn) 
//	public static void printKth(Node root, int k) {
//		if (root == null) {
//			return;
//		}
//		printKth(root.left, k);
//		count++;
//		if (count == k) {
//			System.out.println(root.key);
//			return;
//		}
//		printKth(root.right, k);
//	}
}
