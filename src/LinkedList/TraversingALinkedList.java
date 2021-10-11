package LinkedList;

public class TraversingALinkedList {
	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

//time complexity : O(n) and space complexi
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
		head.next = temp1;
		temp1.next = temp2;
//		System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);
		printList(head);

	}
}
