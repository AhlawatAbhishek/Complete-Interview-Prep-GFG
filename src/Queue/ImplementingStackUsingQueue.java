package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementingStackUsingQueue {
	static class Stack {
		Stack() {
			curr_size = 0;
		}

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		int curr_size;

		int size() {
			if (q1.isEmpty()) {
				return 0;
			} else {
				return curr_size;
			}
		}

		int pop() {
			if (q1.isEmpty()) {
				return -1;
			} else {
				curr_size--;
				return q1.poll();
			}
		}

		public void push(int x) {
			if (q1.isEmpty()) {
				q1.offer(x);
				curr_size++;
			} else {
				q2.add(x);

				while (!q1.isEmpty()) {
					q2.add(q1.peek());
					q1.remove();
				}

				Queue<Integer> q = q1;
				q1 = q2;
				q2 = q;
				curr_size++;

//				while (!q1.isEmpty()) {
//					q2.offer(q1.poll());
//				}
//				q1.offer(x);
//				while (!q2.isEmpty()) {
//					q1.offer(q2.poll());
//				}
//				curr_size++;
			}
		}

		public int top() {
			if (q1.isEmpty()) {
				return -1;
			} else {
				return q1.peek();
			}
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push(5);
		s.push(15);
		s.push(20);

		System.out.println("current size: " + s.size());
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());

		System.out.println("current size: " + s.size());

	}

}
