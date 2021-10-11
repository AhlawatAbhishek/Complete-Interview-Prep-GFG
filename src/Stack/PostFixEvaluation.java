package Stack;

import java.util.Stack;

public class PostFixEvaluation {
	static int evaluatePostfix(String exp) {
		Stack<Integer> st = new Stack<>();
		for (char c : exp.toCharArray()) {
			if (Character.isDigit(c)) {
				int x = c - '0';
				st.push(x);
			} else {
				int res = 0;
				int x = st.pop(), y = st.pop();
				switch (c) {
				case '*':
					res = y * x;
					break;
				case '/':
					res = y / x;
					break;
				case '+':
					res = y + x;
					break;
				case '-':
					res = y - x;
					break;
				}
				st.push(res);
			}
		}
		return st.pop();
	}

	public static void main(String[] args) {
		String exp = "231*+9-";
		System.out.println("postfix evaluation: " + evaluatePostfix(exp));
	}

}
