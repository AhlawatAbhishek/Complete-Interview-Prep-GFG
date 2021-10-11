package LinkedList;

public class NthNodeFromTheEndOfLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

	// Time Complexity : O(n) and space complexity : O(1)
	private static void printNthNodeFromEndUsingLenghtOfLinkedList(Node head, int n) {
		if (head == null) {
			return;
		}
		int len = 0;
		for (Node curr = head; curr != null; curr = curr.next) {
			len++;
		}
		if (n > len) {
			return;
		}
		Node curr = head;
		for (int i = 1; i < len - n + 1; i++) {
			curr = curr.next;
		}
		System.out.println(curr.data);
	}

	// Time Complexity : O(n) and space complexity : O(1)
	public static void nthNodeFromEndUsingTwoPointer(Node head, int n) {
		if (head == null) {
			return;
		}
		Node first = head;
		for (int i = 1; i <= n; i++) {
			if (first == null) {
				return;
			}
			first = first.next;
		}
		Node second = head;
		while (first != null) {
			second = second.next;
			first = first.next;
		}
		System.out.println(second.data);
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
		printNthNodeFromEndUsingLenghtOfLinkedList(head, 2);
		nthNodeFromEndUsingTwoPointer(head, 2);
//		System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);

	}
}
