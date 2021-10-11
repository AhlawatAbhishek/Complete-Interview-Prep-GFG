package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectLoop {
	static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

//using refrences and changing structure of LinkedList
//	Time complexity : O(N) and space complexity or auxiliary space : O(1)
	public static boolean isLoop(Node head) {
		if (head == null) {
			return false;
		}
		if (head != null) {
			if (head.next == null) {
				return false;
			} else if (head.next == head) {
				return true;
			}
		}
		Node temp = new Node(-11);
		Node curr = head, next = null;
		while (curr != null) {
			next = curr.next;
			if (curr.next == null) {
				return false;
			}
			if (curr.next == temp) {
				return true;
			}
			curr.next = temp;
			curr = next;
		}
		return false;
	}

//	Time complexity : O(N) and space complexity or auxiliary space : O(N)
	public static boolean isLoopUsingHashing(Node head) {
		if (head == null) {
			return false;
		}
		if (head != null) {
			if (head.next == null) {
				return false;
			} else if (head.next == head) {
				return true;
			}
		}
		Set<Node> set = new HashSet<>();
		Node curr = head;
		while (curr != null) {
			if (set.contains(curr)) {
				return true;
			}
			set.add(curr);
			curr = curr.next;
		}
		return false;
	}

//	Time complexity : O(N) and space complexity or auxiliary space : O(1)
	public static boolean isLoopUsingFloydCycleDetect(Node head) {
		if (head == null) {
			return false;
		}
		if (head != null) {
			if (head.next == null) {
				return false;
			} else if (head.next == head) {
				return true;
			}
		}
		Node fast = head, slow = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Node head = new Node(15);
		head.next = new Node(10);
		head.next.next = new Node(12);
		head.next.next.next = new Node(20);
		head.next.next.next.next = head.next;
		if (isLoopUsingFloydCycleDetect(head))
			System.out.print("Loop found");
		else
			System.out.print("No Loop");
//		if (isLoopUsingHashing(head))
//			System.out.print("Loop found");
//		else
//			System.out.print("No Loop");
//		if (isLoop(head))
//			System.out.print("Loop found");
//		else
////			System.out.print("No Loop");
	}
}
