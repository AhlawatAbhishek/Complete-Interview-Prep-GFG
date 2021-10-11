package Tree;

public class InPlaceDoublyLinkedListFromTree {

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
		root.left = new Node(5);
		root.right = new Node(20);
		root.right.left = new Node(30);
		root.right.right = new Node(35);

		Node head = BTToDLL(root);
		printList(head);
	}

	static Node prev = null;

//Time complexity: O(n) and space complexity or auxiliary space: O(h / logn),
//	h = height of binary tree
	public static Node BTToDLL(Node root) {
		if (root == null) {
			return null;
		}
		Node head = BTToDLL(root.left);
		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		BTToDLL(root.right);
		return head;
	}

	public static void printList(Node root) {
		Node temp = root;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.right;
		}
	}
}
