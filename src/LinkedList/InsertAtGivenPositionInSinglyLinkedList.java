package LinkedList;

public class InsertAtGivenPositionInSinglyLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

//Time Complexity : theta(position)
//	private static Node insertAtPosition(Node head, int data, int pos) {
//		Node newNode = new Node(data);
//		if (pos == 1) {
//
//			newNode.next = head;
//			head = newNode;
//			return head;
//		}
//		Node curr = head;
//		for (int i = 1; i <= pos - 2 && curr != null; i++) {
//			curr = curr.next;
//		}
//		if (curr == null) {
//			return head;
//		}
//		newNode.next = curr.next;
//		curr.next = newNode;
//		return head;
//	}
	static void insertAtPosition(Node head, int pos, int data) {
		// your code here
		Node newNode = new Node(data);
		Node temp = head;
		if (head == null) {
			head = newNode;
			return;
		}
		if (pos == 0) {
			newNode.next = head;
			newNode = head;
			return;
		}
		int i = 0;
		while (temp != null) {
			if (pos - i - 1 == 0) {
				newNode.next = temp.next;
				temp.next = newNode;
				break;
			}
			temp = temp.next;
			i++;
		}
	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print(temp.data);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);
//		Node newNode = new Node(100);
		head.next = temp1;
		temp1.next = temp2;
//		Node newHead = insertAtPosition(head, 100, 1);
		insertAtPosition(head, 1, 100);
		printList(head);
//		System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);

	}

}
