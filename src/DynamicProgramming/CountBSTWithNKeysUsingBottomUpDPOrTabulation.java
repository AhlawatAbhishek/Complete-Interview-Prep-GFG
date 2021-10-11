package DynamicProgramming;

public class CountBSTWithNKeysUsingBottomUpDPOrTabulation {
//    Time complexity : Theta(N*N) and auxiliary space required is theta(n) we can use Catalan number 
//	for it res(n) = (1/n+1) * 2n C n (C - combination);
	static int countBST(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i <= n; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++) {
				dp[i] += dp[i] * dp[i - j - 1];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
