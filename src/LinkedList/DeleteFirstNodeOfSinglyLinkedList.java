package LinkedList;

public class DeleteFirstNodeOfSinglyLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

//Time Complexity : O(1)
	private static Node delHead(Node head) {
		if (head == null) {
			return null;
		}
		head = head.next;
		return head;
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
		Node newNode = new Node(100);
		head.next = temp1;
		temp1.next = temp2;
		Node newHead = delHead(head);
		printList(newHead);
//		System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);

	}

}
