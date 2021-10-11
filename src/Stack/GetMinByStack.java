package Stack;

import java.util.Stack;

class MyStack2 {

	Stack<Integer> s;
	int min;

	MyStack2() {
		s = new Stack<>();
	}

	void push(int x) {

		if (s.isEmpty()) {
			min = x;
			s.add(x);
		} else if (x <= min) {
			s.add(x - min);
			min = x;
		} else {
			s.add(x);
		}
	}

	int pop() {

		int t = s.peek();
		s.pop();
		if (t <= 0) {
			int res = min;
			min = min - t;
			return res;
		} else {
			return t;
		}
	}

	int peek() {
		int t = s.peek();
		return ((t <= 0) ? min : t);
	}

	// Time complexity : O(1) and space complexity : O(1) but works only when stack
	// contains all +ve elements
	public int getMin() {
		return min;
	}
}

public class GetMinByStack {

	public static void main(String[] args) {
		MyStack2 s = new MyStack2();
		s.push(4);
		s.push(5);
		s.push(8);
//		System.out.println(" Minimum Element from Stack: " + s.getMin());
		s.push(1);
//		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(" Minimum Element from Stack: " + s.getMin());
	}

}
