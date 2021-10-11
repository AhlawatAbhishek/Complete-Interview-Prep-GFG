package Stack;

import java.util.Stack;

public class StackBuiltIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
//		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());

	}

}
