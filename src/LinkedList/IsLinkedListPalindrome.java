package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsLinkedListPalindrome {
	static class Node {
		char data;
		Node next;

		Node(char x) {
			data = x;
			next = null;
		}
	}

//  Time complexity : O(N) and space complexity or auxiliary space: O(1)
	public static boolean isPalindrome1(Node head) {
		Node fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node head2 = reverse(slow);
		fast = head;
		while (head2 != null) {
			if (fast.data != head2.data) {
				return false;
			}
			fast = fast.next;
			head2 = head2.next;
		}
		return true;
	}

	public static Node reverse(Node head) {
		Node curr = head, prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}
		return prev;
	}

//    Time complexity : O(N) and space complexity or auxiliary space: O(N)
	public static boolean isPalindrome(Node head) {
		Deque<Character> stack = new ArrayDeque<>();
		for (Node curr = head; curr != null; curr = curr.next) {
			stack.push(curr.data);
		}
		for (Node curr = head; curr != null; curr = curr.next) {
			if (stack.pop() != curr.data) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Node head = new Node('g');
		head.next = new Node('f');
		head.next.next = new Node('g');
		if (isPalindrome1(head))
			System.out.print("Yes");
		else
			System.out.print("No");
	}

}
