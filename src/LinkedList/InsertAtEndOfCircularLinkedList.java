package LinkedList;

public class InsertAtEndOfCircularLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

	// Time complexity theta(N) and space complexity(auxiliary space) O(1)
	private static Node insertAtEnd(Node head, int x) {
		Node temp = new Node(x);
		if (head == null) {
			temp.next = temp;
			return temp;
		} else {
			Node curr = head;
			while (curr.next != head) {
				curr = curr.next;
			}
			curr.next = temp;
			temp.next = head;
		}
		return head;
	}

	// Time complexity theta(1) or O(1) and space complexity(auxiliary space) O(1)
	private static Node insertAtEndEfficient(Node head, int x) {
		Node temp = new Node(x);
		if (head == null) {
			temp.next = temp;
			return temp;
		} else {
			temp.next = head.next;
			head.next = temp;
			int val = head.data;
			head.data = temp.data;
			temp.data = val;
		}
		return temp;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(5);
		head.next.next = new Node(20);
		head.next.next.next = new Node(15);
		head.next.next.next.next = head;
		Node headNew = insertAtEndEfficient(head, 100);
		printList(headNew);
	}

}
