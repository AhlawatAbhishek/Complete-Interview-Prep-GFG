package Stack;

import java.util.Stack;

public class BalancedParenthesisProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "{()}[]";
		if (isBalanced(str)) {
			System.out.println("Balanced");
		} else {
			System.out.println("Unbalanced");
		}
	}

//Time complexity : O(N) and space complexity : O(1);
	public static boolean isBalanced(String str) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
				s.add(str.charAt(i));
			} else {
				if (s.isEmpty() == true) {
					return false;
				} else if (matching(s.peek(), str.charAt(i)) == false) {
					return false;
				} else {
					s.pop();
				}
			}
		}
		return (s.isEmpty() == true);
	}

	public static boolean matching(char a, char b) {
		return ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'));
	}

}
