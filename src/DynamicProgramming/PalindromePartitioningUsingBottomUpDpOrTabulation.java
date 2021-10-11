package DynamicProgramming;

public class PalindromePartitioningUsingBottomUpDpOrTabulation {
//	Time complexity  : There could be O(n^2) unique sub-problems to any MCM given problem and for every such sub-problem there could be O(n) splits possible.
//  So it is O(n^3).
//	Space complexity : theta(n^2);
	public static boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l++) != s.charAt(r--)) {
				return false;
			}
		}
		return true;
	}

	static int palPart(String str) {
		int n = str.length();
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 0;
		}
		for (int gap = 1; gap < n; gap++) {
			for (int i = 0; i + gap < n; i++) {
				int j = i + gap;
				if (isPalindrome(str, i, j)) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
					}
				}
			}
		}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "geek";
		System.out.println("Minimum Partition Required: " + palPart(str));
	}

}
