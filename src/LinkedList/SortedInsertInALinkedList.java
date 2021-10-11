package LinkedList;

public class SortedInsertInALinkedList {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

//Time Complexity : theta(position), position is the place(index) where insertion is done
	private static Node sortedInsert(Node head, int data) {
		if (head == null) {
			return new Node(data);
		}
		Node newNode = new Node(data), temp = head, prev = temp;
		while (temp != null) {

			if (temp.data > data && temp == head) {
				newNode.next = head;
				head = newNode;
				return head;
			} else if (temp.data > data) {
				prev.next = newNode;
				newNode.next = temp;
				return head;
			}
			prev = temp;
			temp = temp.next;
		}
		if (prev.data <= data) {
			prev.next = newNode;
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
		Node newNode = new Node(100);
		head.next = temp1;
		temp1.next = temp2;
		Node newHead = sortedInsert(head, 9);
		printList(newHead);
//		System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);

	}

}
