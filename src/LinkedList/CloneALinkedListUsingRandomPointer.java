package LinkedList;

import java.util.HashMap;

public class CloneALinkedListUsingRandomPointer {
	static class Node {
		int data;
		Node next, random;

		Node(int x) {
			data = x;
			next = random = null;
		}
	}

	public static void print(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

//Time complexity : O(N) and space complexity: O(N)
	public static Node clone(Node head) {
		HashMap<Node, Node> map = new HashMap<>();
		for (Node curr = head; curr != null; curr = curr.next) {
			map.put(curr, new Node(curr.data));
		}
		for (Node curr = head; curr != null; curr = curr.next) {
			Node clone = map.get(curr);
			clone.next = map.get(curr.next);
			clone.random = map.get(curr.random);
		}
		return map.get(head);
	}

	public static Node clone2(Node head) {
		Node newHead, temp;
		for (Node curr = head; curr != null; curr = curr.next.next) {
			Node newNode = new Node(curr.data);
			newNode.next = curr.next;
			curr.next = newNode;
		}
		for (Node curr = head; curr != null; curr = curr.next.next) {
			curr.next.random = curr.random != null ? curr.random.next : null;
		}
		newHead = head.next;
		Node curr = head;
		temp = newHead;
		while (curr != null && temp != null) {
			curr.next = curr.next != null ? curr.next.next : null;
			temp.next = temp.next != null ? temp.next.next : null;
			curr = curr.next;
			temp = temp.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(5);
		head.next.next = new Node(20);
		head.next.next.next = new Node(15);
		head.next.next.next.next = new Node(20);

		head.random = head.next.next;
		head.next.random = head.next.next.next;
		head.next.next.random = head;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head.next.next.next;

		System.out.print("Original list : \n");
		print(head);

		System.out.print("\nCloned list : \n");
		Node cloned_list = clone2(head);
		print(cloned_list);
	}

}
