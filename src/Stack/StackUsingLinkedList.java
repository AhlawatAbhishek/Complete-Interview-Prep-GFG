package Stack;

public class StackUsingLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head;
	int size = 0;

	StackUsingLinkedList() {
		head = null;
		size = 0;
	}

	boolean isEmpty() {
		return (head == null);
	}

	void push(int x) {
		Node temp = new Node(x);
		temp.next = head;
		head = temp;
		size++;
	}

	int pop() {
		if (head == null) {
			return Integer.MAX_VALUE;
		}
		int res = head.data;
		head = head.next;
		size--;
		return res;
	}

	int peek() {
		if (head == null) {
			return Integer.MAX_VALUE;
		}
		return head.data;
	}

	int size() {
		return size;
	}

	public static void main(String[] args) {
		StackUsingLinkedList s = new StackUsingLinkedList();
		s.push(5);
		s.push(10);
		s.push(20);
		System.out.println(s.pop());
		System.out.println(s.size());
		System.out.println(s.peek());
		System.out.println(s.isEmpty());
	}

}
