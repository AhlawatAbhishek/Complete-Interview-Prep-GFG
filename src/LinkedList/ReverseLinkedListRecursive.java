package LinkedList;

public class ReverseLinkedListRecursive {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

	// time complextiy : O(n) and space complexity(for stack space used) : O(n)
	private static Node reverseLinkedListRecursive(Node curr, Node prev) {
		if (curr == null) {
			return prev;
		}
		Node next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
		return reverseLinkedListRecursive(curr, prev);
	}

//time complextiy : O(n) and space complexity(for stack space used) : O(n) 
	private static Node recRev(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node rest_head = recRev(head.next);
		Node rest_tail = head.next;
		rest_tail.next = head;
		head.next = null;
		return rest_head;

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
//			Node newNode = new Node(100);
		head.next = temp1;
		temp1.next = temp2;
		Node newHead = recRev(head);
		printList(newHead);
//			System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);

	}

}
