package Stack;

import java.util.Stack;

public class EvaluatePrifixNotation {
//	Time complexity : O(N) and space complexity or auxiliary space : O(N)
	static int evaluatePrefix(String exp) {
		Stack<Integer> st = new Stack<>();
		for (int i = exp.length() - 1; i >= 0; i--) {
			char c = exp.charAt(i);
			if (Character.isDigit(c)) {
				int x = c - '0';
				st.push(x);
			} else {
				int res = 0;
				int y = st.pop(), x = st.pop();
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
		String exprsn = "+9*26";
		System.out.println(evaluatePrefix(exprsn));
	}

}
