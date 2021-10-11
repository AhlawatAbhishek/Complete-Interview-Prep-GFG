package DynamicProgramming;

public class KnapsackProblem0_1UsingBottomUpDPOrTabulation {
//	time complexity: theta(NW), pseudo polynomial and space complexity : O(N*W)
	static int knapSack(int W, int wt[], int val[], int n) {

		int dp[][] = new int[n + 1][W + 1];

		for (int i = 0; i <= W; i++) {
			dp[0][i] = 0;
		}

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
			}
		}

		return dp[n][W];
//		 int dp[][] = new int[W+1][N+1];
		// for(int i = 0; i<W+1; i++){
		// dp[i][0] = 0;
		// }
		// for(int i = 0; i<N+1; i++){
		// dp[0][i] = 0;
		// }
		// for(int i = 1; i<W+1; i++){
		// for(int j = 1; j<N+1; j++){
		// if(i -wt[j-1] >= 0){
		// dp[i][j] = Math.max(dp[i][j-1], val[j-1] + dp[i-wt[j-1]][j-1]);
		// }else{
		// dp[i][j] = dp[i][j-1];
		// }
		// }
		// }
		// return dp[W][N];
	}

	public static void main(String[] args) {
		int val[] = { 10, 40, 30, 50 };
		int wt[] = { 5, 4, 6, 3 };
		int W = 10;
		int n = 4;

		System.out.println(knapSack(W, wt, val, n));

	}

}
