package LinkedList;

public class SearchInALinkedList {

	static class Node {
		int data;
		Node next;

		Node(int x) {
			this.data = x;
			this.next = null;
		}
	}

	// Time complexity : O(N) or theta(N) and space complexity: O(1) or theta(1)
	private static int searchIterative(Node head, int key) {
		Node temp = head;
		int count = 0, ans = -1;
		while (temp != null) {
			count++;
			if (temp.data == key) {
				return count;
			}
			temp = temp.next;
		}
		return ans;
	}

//Time complexity : O(N) and space complexity: O(n)
	private static int searchRecursive(Node head, int key, int count) {
		if (head == null) {
			return -1;
		}
		if (head.data == key) {
			return count + 1;
		}
		return searchRecursive(head.next, key, count + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);
		head.next = temp1;
		temp1.next = temp2;
//		System.out.println(head.data + "->" + temp1.data + "->" + temp2.data);
//		System.out.println(searchIterative(head, 30));
		System.out.println(searchRecursive(head, 30, 0));

	}

}
