package Tree;

import java.util.ArrayList;

public class SerializeAndDeSerializeBinaryTree {
	int index = 0;

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
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.right.left = new Node(40);
		root.right.right = new Node(50);
//		inOrder(root);
		ArrayList<Integer> al = new ArrayList<>();
		serialize(root, al);
		Node retrivedRoot = new SerializeAndDeSerializeBinaryTree().deSerialize(al);
		for (int i : al) {
			System.out.print(i + " ");
		}
		System.out.println();
		preOrder(root);
		System.out.println();
		preOrder(retrivedRoot);
	}

	public static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	// Time complexity: 0(n) and space complexity or auxiliary space = 0(logn / h)
	// for recursion call stack
	public Node deSerialize(ArrayList<Integer> al) {
		if (index >= al.size()) {
			return null;
		}
		int val = al.get(index);
		index++;
		if (val == -1)
			return null;
		Node root = new Node(val);
		root.left = deSerialize(al);
		root.right = deSerialize(al);
		return root;
	}

//Time complexity: 0(n) and space complexity or auxiliary space = 0(n) for arrayList
	public static void serialize(Node root, ArrayList<Integer> al) {
		if (root == null) {
			al.add(-1);
			return;
		}
		al.add(root.data);
		serialize(root.left, al);
		serialize(root.right, al);
	}
}
