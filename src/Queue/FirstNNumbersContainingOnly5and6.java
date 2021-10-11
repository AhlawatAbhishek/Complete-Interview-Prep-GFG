package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNNumbersContainingOnly5and6 {
	public static void printFirstN(int n) {
		Queue<String> queue = new LinkedList<>();
		queue.offer("5");
		queue.offer("6");
		for (int i = 0; i < n; i++) {
			String curr = queue.poll();
			System.out.print(curr + " ");
			queue.offer(curr + "5");
			queue.offer(curr + "6");
		}
	}

	public static void main(String[] args) {
		int n = 5;

		printFirstN(n);

	}

}
