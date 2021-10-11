package BinarySearchTree;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSumInBST {
	static class Node {
		int key;
		Node left;
		Node right;

		Node(int k) {
			key = k;
			left = right = null;
		}
	}

	public static void populateMap(Node root, int hd, TreeMap<Integer, Integer> map) {
		if (root == null) {
			return;
		}
		populateMap(root.left, hd - 1, map);
		int prevSum = map.containsKey(hd) ? map.get(hd) : 0;
		map.put(hd, prevSum + root.key);
		populateMap(root.right, hd + 1, map);
	}

// let hd = number of horizontal distances 
//	Time compelxity : O(n *log(hd)) and space complexity : O(hd)
	public static void vSum(Node root) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		populateMap(root, 0, map);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(50);
		root.left.left = new Node(30);
		root.left.right = new Node(40);

		vSum(root);
	}

}
