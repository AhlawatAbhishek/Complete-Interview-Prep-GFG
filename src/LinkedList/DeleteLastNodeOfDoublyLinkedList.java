package LinkedList;

public class DeleteLastNodeOfDoublyLinkedList {
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

	public static void printlist(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

//time complexity : O(N) or theta(N) and space complexity(auxiliary space) : O(1)
	public static Node deleteLast(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node curr = head;
		while (curr.next.next != null) {
			curr = curr.next;
		}
		Node last = curr.next;
		last.prev = null;
		curr.next = null;
		return head;
	}

	public static void main(String args[]) {
		Node head = new Node(10);
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);
		head.next = temp1;
		temp1.prev = head;
		temp1.next = temp2;
		temp2.prev = temp1;
		Node newHead = deleteLast(head);
		printlist(newHead);

	}

}
