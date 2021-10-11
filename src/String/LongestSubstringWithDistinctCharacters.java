package String;

import java.util.Arrays;

public class LongestSubstringWithDistinctCharacters {
//Time complexity : O(N^3) and space complexity or auxiliary space: O(1)
	public static int longestDistinct(String str) {
		int res = Integer.MIN_VALUE;
		int n = str.length();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (areDistinct(str, i, j)) {
					res = Math.max(res, j - i + 1);
				}
			}
		}
		return res == Integer.MIN_VALUE ? 0 : res;
	}

	// Time complexity : O(N^2) and space complexity or auxiliary space: O(n*256)
	public static int longestDistinct2(String str) {
		int res = Integer.MIN_VALUE;
		int n = str.length();
		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[256];
			for (int j = i; j < n; j++) {
				if (visited[str.charAt(j)] == true) {
					break;
				} else {
					res = Math.max(res, j - i + 1);
					visited[str.charAt(j)] = true;
				}
			}
		}
		return res == Integer.MIN_VALUE ? 0 : res;
	}

	// Time complexity : O(N) and space complexity or auxiliary space: O(256)
	public static int longestDistinct3(String str) {
		int res = Integer.MIN_VALUE;
		int n = str.length();
		int[] prev = new int[256];
		Arrays.fill(prev, -1);
		int i = 0;
		for (int j = 0; j < n; j++) {
			i = Math.max(i, prev[str.charAt(j)] + 1);
			int maxTillHere = j - i + 1;
			res = Math.max(res, maxTillHere);
			prev[str.charAt(j)] = j;
		}
		return res;
	}

	public static boolean areDistinct(String str, int i, int j) {
		boolean[] visited = new boolean[256];
		for (int k = i; k <= j; k++) {
			char c = str.charAt(k);
			if (visited[c]) {
				return false;
			} else {
				visited[c] = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int len = longestDistinct3(str);
		System.out.print("The length of the longest distinct characters substring is " + len);
	}

}
