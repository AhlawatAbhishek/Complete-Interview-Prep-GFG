package BinarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePostOrder {
	static class Node {
		Node left, right;
		int data;

		Node(int key) {
			left = null;
			right = null;
			this.data = key;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(15);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.right = new Node(20);
		root.right.left = new Node(18);
		root.right.left.left = new Node(16);
		root.right.right = new Node(80);
		ArrayList<Integer> al = postOrder(root);
		for (int i : al) {
			System.out.print(i + " ");
		}
	}

	public static ArrayList<Integer> postOrder(Node root) {
		// your code here
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Node> s = new Stack<Node>();
		if (root == null) {
			return list;
		}
		s.push(root);
		Node prev = null;
		while (!s.isEmpty()) {
			Node curr = s.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					s.push(curr.left);
				} else if (curr.right != null) {
					s.push(curr.right);
				} else {
					s.pop();
					list.add(curr.data);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					s.push(curr.right);
				} else {
					s.pop();
					list.add(curr.data);
				}
			} else if (curr.right == prev) {
				s.pop();
				list.add(curr.data);
			}
			prev = curr;
		}
		return list;
	}

}
