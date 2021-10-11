package LinkedList;

public class InsertAtBeginDoublyLinkedList {
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

	private static void printList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

//time complexity : O(1) and space complexity(auxiliary space) : O(1)
	private static Node insertAtBegin(Node head, int data) {
		Node temp = new Node(data);
		temp.next = head;
		if (head != null) {
			head.prev = temp;
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);
		head.next = temp1;
		temp1.prev = head;
		temp1.next = temp2;
		temp2.prev = temp1;
		Node newHead = insertAtBegin(head, 100);
		printList(newHead);
	}

}
