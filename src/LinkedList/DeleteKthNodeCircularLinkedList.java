package LinkedList;

public class DeleteKthNodeCircularLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

	public static void printList(Node head) {
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

	// time complexity : O(N) and space complexity(auxiliary space) : O(1)
	private static Node deleteKthNode(Node head, int k) {
		if (head == null) {
			return head;
		}
		if (k == 1) {
			return deleteHeadEfficient(head);
		}
		Node curr = head;
		for (int i = 0; i < k - 2; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		return head;

	}

//time complexity : theta(N) and space complexity(auxiliary space) : O(1) 
	private static Node deleteHead(Node head) {
		if (head == null) {
			return null;
		}
		if (head.next == head) {
			return null;
		}
		Node curr = head;
		while (curr.next != head) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		head = curr.next;
		return head;
	}

	// time complexity : theta(1) or O(1) and space complexity(auxiliary space) :
	// O(1)
	private static Node deleteHeadEfficient(Node head) {
		if (head == null) {
			return null;
		}
		if (head.next == head) {
			return null;
		}
		head.data = head.next.data;
		head.next = head.next.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(5);
		head.next.next = new Node(20);
		head.next.next.next = new Node(15);
		head.next.next.next.next = head;
		Node headNew = deleteKthNode(head, 2);
		printList(headNew);
	}

}
