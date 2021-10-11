package Tree;

import java.util.ArrayList;

public class LowestCommonAncestor {
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
		int n1 = 20, n2 = 50;

		Node ans = lca(root, n1, n2);
		Node ans1 = lcaEfficient(root, n1, n2);
		System.out.println("LCA: " + ans.data);
		System.out.println("LCA: " + ans1.data);
	}

//  Time complexity : 0(n) and space complexity or auxiliary : O(h) 
	public static Node lcaEfficient(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}
		if (root.data == n1 || root.data == n2) {
			return root;
		}
		Node lca1 = lcaEfficient(root.left, n1, n2);
		Node lca2 = lcaEfficient(root.right, n1, n2);
		if (lca1 != null && lca2 != null) {
			return root;
		} else if (lca1 != null) {
			return lca1;
		} else {
			return lca2;
		}
	}

	public static boolean findPath(Node root, ArrayList<Node> p, int n) {
		if (root == null) {
			return false;
		}
		p.add(root);
		if (root.data == n) {
			return true;
		}
		if (findPath(root.left, p, n) || findPath(root.right, p, n)) {
			return true;
		}
		p.remove(p.size() - 1);
		return false;
	}

//    Time complexity : 0(n) and space complexity or auxiliary : O(h + 2*n) 
	public static Node lca(Node root, int n1, int n2) {
		ArrayList<Node> p1 = new ArrayList<>();
		ArrayList<Node> p2 = new ArrayList<>();
		if (!findPath(root, p1, n1) || !findPath(root, p2, n2)) {
			return null;
		}
		for (int i = 0; i < p1.size() - 1 && i < p2.size() - 1; i++) {
			if (p1.get(i + 1) != p2.get(i + 1)) {
				return p1.get(i);
			}
		}
		return null;
	}
}
