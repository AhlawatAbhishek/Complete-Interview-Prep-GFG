package LinkedList;

public class MiddleOfLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

//Time Complexity : theta(n/2)
	private static void printMiddleNaive(Node head) {
		if (head == null) {
			return;
		}
		int count = 0;
		Node curr;
		for (curr = head; curr != null; curr = curr.next) {
			count++;
		}
		curr = head;
		for (int i = 0; i < count / 2; i++) {
			curr = curr.next;
		}
		System.out.println(curr.data);
	}

	private static void printMiddleEfficient(Node head) {
		if (head == null) {
			return;
		}
		Node slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.data);
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
		Node newNode = new Node(100);
		head.next = temp1;
		temp1.next = temp2;
		temp2.next = newNode;
		printMiddleEfficient(head);
//		System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);

	}

}
