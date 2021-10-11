package BinarySearchTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {
	static class Node {
		int key;
		Node left;
		Node right;

		Node(int k) {
			key = k;
			left = right = null;
		}
	}

	public static void populateList(Node root, ArrayList<Integer> al) {
		if (root == null) {
			return;
		}
		populateList(root.left, al);
		al.add(root.key);
		populateList(root.right, al);
	}

	// Time complexity : O(N) and space complexity or auxiliary space : O(N)
	public static boolean isPairPresentEffi(Node root, int sum, Set<Integer> set) {
		if (root == null) {
			return false;
		}
		if (isPairPresentEffi(root.left, sum, set))
			return true;
		;
		if (set.contains(sum - root.key)) {
			return true;
		} else {
			set.add(root.key);
		}
		return isPairPresentEffi(root.right, sum, set);
	}

//Time complexity : O(N) and space complexity or auxiliary space : O(N)
	public static boolean isPairPresent(Node root, int sum) {
		if (root == null) {
			return false;
		}
		ArrayList<Integer> al = new ArrayList<>();
		populateList(root, al);
		int l = 0, r = al.size() - 1;
		while (l < r) {
			if (al.get(l) > sum) {
				return false;
			}
			if (al.get(l) + al.get(r) < sum) {
				l++;
			} else if (al.get(l) + al.get(r) > sum) {
				r--;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(20);
		root.left.left = new Node(4);
		root.left.right = new Node(9);
		root.right.left = new Node(11);
		root.right.right = new Node(30);
		root.right.right.left = new Node(25);

		int sum = 33;
		Set<Integer> set = new HashSet<>();
		System.out.println(isPairPresent(root, sum));
		System.out.println(isPairPresentEffi(root, sum, set));
	}

}
