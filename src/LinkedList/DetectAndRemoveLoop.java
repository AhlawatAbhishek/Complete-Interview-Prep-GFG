package LinkedList;

public class DetectAndRemoveLoop {
	static class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

//	Time complexity : O(N) and space complexity or auxiliary space : O(1)
	public static boolean isLoopUsingFloydCycleDetect(Node head) {
		if (head == null) {
			return false;
		}
		boolean isFound = false;
		if (head != null) {
			if (head.next == null) {
				return false;
			} else if (head.next == head) {
				System.out.println("Length of loop is 1");
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
				isFound = true;
				break;
			}
		}
		if (isFound) {
			int len = 0;
			slow = slow.next;
			len++;
			while (slow != fast) {
				slow = slow.next;
				len++;
			}
			System.out.println("Length of loop found is:" + (len));
		}
		return isFound;
	}

//	Time complexity : O(N) and space complexity or auxiliary space : O(1)
	public static Node removeLoop(Node head) {
		Node slow = head, fast = head;
		boolean isFound = false;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			if (slow == fast) {
				isFound = true;
				break;
			}
		}
		if (isFound) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
			return slow.next;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(15);
		head.next = new Node(10);
		head.next.next = new Node(12);
		head.next.next.next = new Node(20);
		head.next.next.next.next = head.next;
		if (isLoopUsingFloydCycleDetect(head)) {
			System.out.println("Loop found, Now removing it");
			Node firstNodeOfLoop = removeLoop(head);
			System.out.println("First node of removed loop was: " + firstNodeOfLoop.data);
		} else
			System.out.print("No Loop");

		if (isLoopUsingFloydCycleDetect(head)) {
			System.out.println("Loop found, Now removing it");
			Node firstNodeOfLoop = removeLoop(head);
			System.out.println("First node of removed loop was: " + firstNodeOfLoop.data);
		} else
			System.out.print("No Loop");
	}

}
