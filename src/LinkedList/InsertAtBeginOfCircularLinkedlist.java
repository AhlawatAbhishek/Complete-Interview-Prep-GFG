package LinkedList;

public class InsertAtBeginOfCircularLinkedlist {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

	// Time complexity O(N) and space complexity(auxillary space) O(1)
	private static Node insertBegin(Node head, int x) {
		Node temp = new Node(x);
		if (head == null) {
			temp.next = temp;
		} else {
			Node curr = head;
			while (curr.next != head) {
				curr = curr.next;
			}
			curr.next = temp;
			temp.next = head;
		}
		return temp;
	}

//Time complexity O(1) and space complexity(auxillary space) O(1)
	private static Node insertBeginEfficient(Node head, int x) {
		Node temp = new Node(x);
		if (head == null) {
			temp.next = temp;
		} else {
			temp.next = head.next;
			head.next = temp;
			int value = head.data;
			head.data = temp.data;
			temp.data = value;
		}
		return head;
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
		Node headNew = insertBeginEfficient(head, 100);
		printList(headNew);
	}

}
