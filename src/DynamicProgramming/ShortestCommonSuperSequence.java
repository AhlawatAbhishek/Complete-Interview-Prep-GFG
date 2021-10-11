package DynamicProgramming;

import java.util.Arrays;

public class ShortestCommonSuperSequence {
	static long memo[][];

	public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
		memo = new long[X.length() + 1][Y.length() + 1];
		for (long[] a : memo) {
			Arrays.fill(a, -1);
		}
		int res = X.length() + Y.length() - (int) lcs(X, Y, X.length(), Y.length());
		return res;
	}

	static long lcs(String x, String y, int l1, int l2) {
		if (memo[l1][l2] != -1) {
			return memo[l1][l2];
		}

		if (l1 == 0 || l2 == 0) {
			memo[l1][l2] = 0;
		} else {
			if (x.charAt(l1 - 1) == y.charAt(l2 - 1)) {
				memo[l1][l2] = 1 + lcs(x, y, l1 - 1, l2 - 1);
			} else {
				memo[l1][l2] = Math.max(lcs(x, y, l1 - 1, l2), lcs(x, y, l1, l2 - 1));
			}
		}
		return memo[l1][l2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
