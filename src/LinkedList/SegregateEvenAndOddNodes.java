package LinkedList;

public class SegregateEvenAndOddNodes {
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

//Time complexity: O(N) and space complexity or auxiliary space: O(1)
	public static Node segregate(Node head) {
		Node eStrt = null, eEnd = null, oStrt = null, oEnd = null;
		for (Node curr = head; curr != null; curr = curr.next) {
			if (curr.data % 2 == 0) {
				if (eStrt == null) {
					eStrt = curr;
					eEnd = curr;
				} else {
					eEnd.next = curr;
					eEnd = curr;
				}
			} else {
				if (oStrt == null) {
					oStrt = curr;
					oEnd = curr;
				} else {
					oEnd.next = curr;
					oEnd = curr;
				}
			}
		}
		if (eStrt == null || oStrt == null) {
			return head;
		}
		eEnd.next = oStrt;
		oEnd.next = null;
		return eStrt;
	}

	public static void main(String[] args) {
		Node head = new Node(17);
		head.next = new Node(15);
		head.next.next = new Node(8);
		head.next.next.next = new Node(12);
		head.next.next.next.next = new Node(10);
		head.next.next.next.next.next = new Node(5);
		head.next.next.next.next.next.next = new Node(4);
		printlist(head);
		head = segregate(head);
		printlist(head);
	}

}
