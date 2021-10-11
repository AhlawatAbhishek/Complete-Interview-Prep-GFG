package LinkedList;

public class DeleteNodeWithOnlyPointerGivenToIt {
	static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	public static void printlist(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

//	It is guranteed that this won't be the last node
//	Time complexity : O(1) and space complexity or auxiliary space : O(1)
	public static void deleteNode(Node ptr) {
		ptr.data = ptr.next.data;
		ptr.next = ptr.next.next;
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		Node ptr = new Node(30);
		head.next.next = ptr;
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(25);
		printlist(head);
		deleteNode(ptr);
		printlist(head);
	}

}
