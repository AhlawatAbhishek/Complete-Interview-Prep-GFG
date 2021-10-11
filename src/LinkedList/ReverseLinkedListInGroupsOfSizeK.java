package LinkedList;

public class ReverseLinkedListInGroupsOfSizeK {

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
			System.out.print(curr.data + "->");
			curr = curr.next;
		}
		System.out.println();

	}

//Time complexity: O(N) and space complexity: O(N/K)
	public static Node reverseKRec(Node head, int k) {
		Node curr = head, prev = null, next = null;
		int count = 0;
		while (curr != null && k != count) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if (next != null) {
			Node rest_head = reverseKRec(next, k);
			head.next = rest_head;
		}
		return prev;
	}

	public static Node reverseKIter(Node head, int k) {
		Node prevFirst = null, curr = head;
		boolean isFirstPass = true;
		while (curr != null) {
			Node prev = null, first = curr;
			int count = 0;
			while (curr != null && k != count) {
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			if (isFirstPass) {
				head = prev;
				isFirstPass = false;
			} else {
				prevFirst.next = prev;
			}
			prevFirst = first;
		}
		return head;
	}

	public static void main(String[] args) {

		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(70);
		printlist(head);
//		head = reverseKRec(head, 3);
		head = reverseKIter(head, 3);
		printlist(head);

	}

}
