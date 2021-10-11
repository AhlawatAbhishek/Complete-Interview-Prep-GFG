package Stack;

import java.util.Stack;

class MyStack {
	Stack<Integer> ms = null;
	Stack<Integer> as = null;

	MyStack() {
		ms = new Stack<>();
		as = new Stack<>();
	}

	public void push(int x) {
		ms.push(x);
		if (as.isEmpty()) {
			as.push(x);
		} else if (as.peek() >= ms.peek()) {
			as.push(x);
		}
	}

	public int pop() {
		int item = ms.pop();
		if (as.peek() == item) {
			as.pop();
		}
		return item;
	}

//Time complexity : O(1) and space complexity for the whole class setup required for this method is O(N)
	public int getMin() {
		if (as.isEmpty()) {
			return -1;
		} else {
			return as.peek();
		}
	}
}

public class GetMinInStack {

	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push(4);
		s.push(5);
		s.push(8);
		s.push(1);
		s.pop();

		System.out.print(" Minimum Element from Stack: " + s.getMin());

	}

}
