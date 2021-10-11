package LinkedList;

public class RemoveDuplicatesFromASinglySortedLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

//time complextiy : O(n) and space complexity : O(1) 
	private static void removeDups(Node head) {
		if (head == null) {
			return;
		}
		Node curr = head;
		while (curr != null && curr.next != null) {
			if (curr.data == curr.next.data) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
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
		Node newNode = new Node(30);
		head.next = temp1;
		temp1.next = temp2;
		temp2.next = newNode;
		removeDups(head);
		printList(head);
//			System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);

	}

}
