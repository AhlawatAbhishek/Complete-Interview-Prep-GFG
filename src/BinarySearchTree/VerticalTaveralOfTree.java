package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTaveralOfTree {
	static class Pair {
		Node root;
		int hd;

		Pair(Node r, int d) {
			this.root = r;
			this.hd = d;
		}
	}

	static class Node {
		int key;
		Node left;
		Node right;

		Node(int k) {
			key = k;
			left = right = null;
		}
	}

	public static void populateMap(Node root, TreeMap<Integer, ArrayList<Integer>> map, int hd) {
		if (root == null) {
			return;
		}
		populateMap(root.left, map, hd - 1);
		if (map.containsKey(hd)) {
			ArrayList<Integer> list = map.get(hd);
			list.add(root.key);
		} else {
			ArrayList<Integer> al = new ArrayList<>();
			al.add(root.key);
			map.put(hd, al);
		}
		populateMap(root.right, map, hd + 1);
	}

//    This give error as in this type traversal level of the node at particular hd is not taken into 
//	consideration
	public static void vTraversal(Node root) {
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		populateMap(root, map, 0);
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			for (int i : entry.getValue()) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

//Time complexity : O(N) and space complexity or auxiliary space: O(N)
	public static void vTraversalCorrect(Node root) {
		if (root == null) {
			return;
		}
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(root, 0));
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Pair p = queue.poll();
				Node n = p.root;
				int hd = p.hd;
				if (map.containsKey(hd)) {
					ArrayList<Integer> li = map.get(hd);
					li.add(n.key);
				} else {
					ArrayList<Integer> al = new ArrayList<>();
					al.add(n.key);
					map.put(hd, al);
				}
				if (n.left != null) {
					queue.offer(new Pair(n.left, hd - 1));
				}
				if (n.right != null) {
					queue.offer(new Pair(n.right, hd + 1));
				}
			}
		}
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			for (int i : entry.getValue()) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);

//		vTraversal(root);
		vTraversalCorrect(root);
	}

}
