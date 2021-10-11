package Stack;

import java.util.Stack;

public class InfixToPrefix {
//Time complexity : O(N) and space complexity: O(N)
	public static String infixToPrefix(String exp) {
		// Your code here
		StringBuilder result = new StringBuilder("");
		Stack<Character> stack = new Stack<>();

		for (int i = exp.length() - 1; i >= 0; i--) {
			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				result.append(c);
			} else if (c == ')') {
				stack.push(c);
			} else if (c == '(') {
				while (!stack.isEmpty() && stack.peek() != ')') {
					result.append(stack.pop());
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && (Perc(c) < Perc(stack.peek()) || (c == '^' && stack.peek() == '^'))) {
					result.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				return "Invalid Expression";
			}
			result.append(stack.pop());
		}
		return result.reverse().toString();
	}

	static int Perc(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = ("x+y*z/w+u");
		System.out.println(infixToPrefix(exp));
	}

}
