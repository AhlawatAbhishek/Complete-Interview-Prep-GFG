package LinkedList;

public class CircularLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

//Time complexity : O(n) and space complexity : O(1)
	private static void printListUsingForLoop(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		for (Node r = head.next; r != head; r = r.next) {
			System.out.print(r.data + " ");
		}
	}

	// Time complexity : O(n) and space complexity : O(1)
	public static void printListUsingDowhileLoop(Node head) {
		if (head == null) {
			return;
		}
		Node r = head;
		System.out.println();
		do {
			System.out.print(r.data + " ");
			r = r.next;
		} while (r != head);
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(5);
		head.next.next = new Node(20);
		head.next.next.next = new Node(15);
		head.next.next.next.next = head;
		printListUsingForLoop(head);
		printListUsingDowhileLoop(head);
	}

}
