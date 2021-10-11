package LinkedList;

public class ReverseDoublyLinkedList {

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;
			prev = null;
			next = null;
		}
	}

	static Node reverse(Node head) {
		if (head == null || head.next == null)
			return head;
		Node prev = null, curr = head;
		while (curr != null) {
			prev = curr.prev;
			curr.prev = curr.next;
			curr.next = prev;
			curr = curr.prev;
		}
		return prev.prev;
	}

	public static void printlist(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Node head = new Node(10);
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);
		head.next = temp1;
		temp1.prev = head;
		temp1.next = temp2;
		temp2.prev = temp1;
		Node newHead = reverse(head);
		printlist(newHead);

	}

}
