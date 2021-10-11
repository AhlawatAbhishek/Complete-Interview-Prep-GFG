package Stack;

import java.util.Stack;

public class EvaluatePostfix {
	public static int evaluatePostFix(String exp) {
		// Your code here
		Stack<Integer> digits = new Stack<>();
		for (char c : exp.toCharArray()) {
			if (Character.isDigit(c)) {
				digits.add(c - '0');
			} else {
				int val1 = digits.pop();
				int val2 = digits.pop();
				switch (c) {
				case '+':
					digits.push(val1 + val2);
					break;
				case '-':
					digits.push(val2 - val1);
					break;
				case '/':
					digits.push(val2 / val1);
					break;
				case '*':
					digits.push(val2 * val1);
					break;
				}
			}
		}
		return digits.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "231*+9-";
		System.out.println("postfix evaluation: " + evaluatePostFix(exp));

	}

}
