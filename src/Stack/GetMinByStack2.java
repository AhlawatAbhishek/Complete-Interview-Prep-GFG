package Stack;

import java.util.Stack;

class MyStack3 {
	Stack<Integer> st = null;
	int min;

	MyStack3() {
		st = new Stack<>();
		min = Integer.MAX_VALUE;
	}

	public void push(int x) {
		if (st.isEmpty()) {
			min = x;
			st.push(x);
		} else if (x <= min) {
			st.push(2 * x - min);
			min = x;
		} else {
			st.push(x);
		}
	}

	public int pop() {
		if (st.isEmpty()) {
			return -1;
		} else {
			int t = st.peek();
			st.pop();
			if (t <= min) {
				int temp = min;
				min = 2 * min - t;
				return temp;
			}
			return t;
		}
	}

	public int peek() {
		int t = st.peek();
		return t <= min ? min : t;
	}

	// Time complexity : O(1) and space complexity or auxiliary space : O(1)
	public int getMin() {
		return min;
	}
}

public class GetMinByStack2 {

	public static void main(String[] args) {
		MyStack3 s = new MyStack3();
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
