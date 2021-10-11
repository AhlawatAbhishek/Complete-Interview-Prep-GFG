package Stack;

import java.util.Stack;

public class InfixToPostfix {
	// Time complexity : O(N) and space complexity: O(N)
	public static String infixToPostfix(String exp) {
		// Your code here
		String result = new String("");
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); ++i) {
			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				result += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && Perc(c) <= Perc(stack.peek())) {
					result += stack.pop();
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				return "Invalid Expression";
			}
			result += stack.pop();
		}
		return result;
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
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostfix(exp));
	}

}
