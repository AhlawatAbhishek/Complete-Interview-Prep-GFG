package LinkedList;

public class insertAtHeadDoublyCircularLinkedList {

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
		if (head == null) {
			return;
		}
		Node curr = head;
		do {
			System.out.print(curr.data + " ");
			curr = curr.next;
		} while (curr != head);
		System.out.println();
	}

//time complexity : O(1) or theta(1) and space complexity(auxiliary space) : O(1)
	public static Node insertAtHead(Node head, int data) {
		Node temp = new Node(data);
		if (head == null) {
			temp.prev = temp;
			temp.next = temp;
			return temp;
		}
		temp.prev = head.prev;
		temp.next = head;
		head.prev.next = temp;
		head.prev = temp;
		return temp;
	}

	public static void main(String args[]) {
		Node head = new Node(10);
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);
		head.next = temp1;
		temp1.prev = head;
		temp1.next = temp2;
		temp2.prev = temp1;
		temp2.next = head;
		head.prev = temp2;
		Node newHead = insertAtHead(head, 100);
		printlist(newHead);

	}

}
