package LinkedList;

import java.util.ArrayList;

public class ReverseLinkedListIterative {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

	// Time complexity : O(n) and space complexity(auxillary space) : O(1)
	private static Node reverseLinkedListEfficient(Node head) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	// Time complexity : O(n) and space complexity(auxillary space) : O(n)

	private static Node reverseLinkedListNaive(Node head) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (Node curr = head; curr != null; curr = curr.next) {
			arr.add(curr.data);
		}
		for (Node curr = head; curr != null; curr = curr.next) {
			curr.data = arr.remove(arr.size() - 1);
		}
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
//		Node newNode = new Node(100);
		head.next = temp1;
		temp1.next = temp2;
		Node newHead = reverseLinkedListEfficient(head);
		printList(newHead);
//		System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);

	}

}
