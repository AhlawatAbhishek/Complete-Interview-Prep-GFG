package DynamicProgramming;

public class NCrUsingBottomUpDpOrTabulation {
// if(r== n || r == 0) -> 1, if(n < r) -> 0, nCr = nCr(n-1, r-1) + nCr(n-1, r)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int nCrModp(int n, int r) {
		if (n < r) {
			return 0;
		}
		if (n == r || r == 0) {
			return 1;
		}
		// your code here
		int[][] dp = new int[n + 1][r + 1];
		// Arrays.fill(dp, 0);
		for (int i = 0; i <= r; i++)
			dp[i][i] = 1;
		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= r; i++)
			dp[i + 1][i] = i + 1;
		for (int i = 1; i <= n; i++)
			dp[i][1] = i;

		for (int i = 4; i <= n; i++) {
			for (int j = 2; j <= r && j < i; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 1000000007;
			}
		}

		return dp[n][r];
	}

}
