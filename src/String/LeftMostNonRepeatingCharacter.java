package String;

import java.util.Arrays;

public class LeftMostNonRepeatingCharacter {
	private static final int CHAR = 256;

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(leftMostNonRepChar2(str));
	}

// Time complexity = O(N+CHAR) or O(N) and Space Complexity(Auxillary space) = O(CHAR) or O(1);
	public static int leftMostNonRepChar(String str) {
		int count[] = new int[CHAR];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			count[c]++;
		}
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (count[c] == 1) {
				return i;
			}
		}
		return -1;
	}

//Time Complexity = O(N+CHAR) or O(N) and Space Complexity = O(CHAR) or O(1)
	public static int leftMostNonRepChar2(String str) {

		for (int i = 0; i < str.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				return i;
			}
		}
		return -1;
	}

//	Time Complexity = theta(N+CHAR)  and Space Complexity = theta(CHAR)
	public static int leftMostNonRepChar3(String str) {
		int count[] = new int[CHAR];
		Arrays.fill(count, -1);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (count[c] == -1) {
				count[c] = i;
			} else {
				count[c] = -2;
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				res = Math.min(res, count[i]);
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}
}
