package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class FindIntersectionOfTwoLinkedLists {
	static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	// Time complexity: O(N) and space complexity or auxiliary space : O(N)
	public static int getIntesection2(Node head1, Node head2) {
		Set<Node> set = new HashSet<>();
		for (Node curr = head1; curr != null; curr = curr.next) {
			set.add(curr);
		}
		for (Node curr = head2; curr != null; curr = curr.next) {
			if (set.contains(curr)) {
				return curr.data;
			}
		}
		return -1;
	}

//Time complexity: O(N) and space complexity or auxiliary space : O(1)
	public static int getIntersection(Node head1, Node head2) {
		int len1 = 0, len2 = 0;
		for (Node curr = head1; curr != null; curr = curr.next) {
			len1++;
		}
		for (Node curr = head2; curr != null; curr = curr.next) {
			len2++;
		}
		Node curr2 = head2, curr1 = head1;
		if (len1 < len2) {
			for (int k = 1; k <= Math.abs(len2 - len1) && curr2 != null; k++) {
				curr2 = curr2.next;
			}
		} else {
			for (int k = 1; k <= Math.abs(len1 - len2) && curr1 != null; k++) {
				curr1 = curr1.next;
			}
		}
		while (curr1 != null && curr2 != null) {
			if (curr1 == curr2) {
				return curr1.data;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return -1;
	}

	public static void main(String[] args) {
		Node newNode;

		Node head1 = new Node(10);

		Node head2 = new Node(3);

		newNode = new Node(6);
		head2.next = newNode;

		newNode = new Node(9);
		head2.next.next = newNode;

		newNode = new Node(15);
		head1.next = newNode;
		head2.next.next.next = newNode;

		newNode = new Node(30);
		head1.next.next = newNode;

		head1.next.next.next = null;

		System.out.println(getIntersection(head1, head2));
		System.out.println(getIntesection2(head1, head2));
	}

}
