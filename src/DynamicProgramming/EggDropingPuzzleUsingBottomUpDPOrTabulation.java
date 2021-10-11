package DynamicProgramming;

public class EggDropingPuzzleUsingBottomUpDPOrTabulation {
//   Time complexity : O(f^2, e) and space complexity : O(fe)
	static int res(int e, int f) {
		int dp[][] = new int[f + 1][e + 1];
		for (int i = 0; i <= e; i++) {
			dp[1][i] = 1;
			dp[0][i] = 0;
		}
		for (int j = 1; j <= f; j++) {
			dp[j][1] = j;
		}
		for (int i = 2; i <= f; i++) {
			for (int j = 2; j <= e; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int x = 0; x <= i; x++) {
//                                                   egg broke              egg did not broke    			
					dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
				}
			}
		}
		return dp[f][e];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
