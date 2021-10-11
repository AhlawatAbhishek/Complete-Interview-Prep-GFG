package LinkedList;

public class RecursiveTraveralOfSinglyLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

	// time complexity : O(n) and space complexity or auxillary space : O(n)(for
	// recursion stack)
	public static void rPrint(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		rPrint(head.next);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);
		head.next = temp1;
		temp1.next = temp2;
//		System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);
		rPrint(head);

	}

}
