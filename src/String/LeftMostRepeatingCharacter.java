package String;

import java.util.Arrays;

public class LeftMostRepeatingCharacter {
	public static final int CHAR = 256;

	public static void main(String args[]) {
		String str = "abbcc";
//		"GeeksforGeeks" "abbcc" "abcd"
		System.out.println(leftMostRepChar3(str));
	}

	public static int leftMostRepChar(String str) {
		int count[] = new int[CHAR];
		for (char c : str.toCharArray()) {
			count[c]++;
		}
		int ans = -1;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (count[c] > 1) {
				ans = i;
				break;
			}
		}
		return ans;
	}

//	O(n^2)
	public static int leftMostRepChar1(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return i;
				}
			}
		}
		return -1;
	}

//  time complexity : O(N+CHAR) ,, space complexity(auxillary space) : O(CHAR) or O(1);
	public static int leftMostRepChar2(String str) {
		int[] fIndex = new int[CHAR];
		Arrays.fill(fIndex, -1);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < str.length(); i++) {
			int fi = fIndex[str.charAt(i)];
			if (fi == -1) {
				fIndex[str.charAt(i)] = i;
			} else {
				res = Math.min(res, fi);
			}
		}
		return (res == Integer.MAX_VALUE ? -1 : res);
	}

//  time complexity : O(N+CHAR) or O(N) ,, space complexity(auxillary space) : O(CHAR) or O(1);
	public static int leftMostRepChar3(String str) {
		boolean[] visited = new boolean[CHAR];
		int res = -1;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (!visited[str.charAt(i)]) {
				visited[str.charAt(i)] = true;
			} else {
				res = i;
			}
		}
		return res;
	}
}
