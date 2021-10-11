package Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingAQueue {
	static Queue<Integer> queue;

//Time complexity: O(n) and auxiliary space : O(n)
	public static void reversequeue() {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
	}

	// Time complexity: O(n) and auxiliary space : O(n) for recursive call stack
	public static void Print() {
		Iterator<Integer> it = queue.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void reverseRec() {
		if (queue.isEmpty()) {
			return;
		}
		int item = queue.poll();
		reverseRec();
		queue.offer(item);
	}

	public static void main(String[] args) {
		queue = new LinkedList<Integer>();
		queue.add(12);
		queue.add(5);
		queue.add(15);
		queue.add(20);

		reversequeue();
		reverseRec();
		Print();

	}

}
