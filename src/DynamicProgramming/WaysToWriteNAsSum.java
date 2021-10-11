package DynamicProgramming;

//Number partitioning problem - ways a number n can be formed by using 1 to n-1 numbers
public class WaysToWriteNAsSum {
	int countWays(int n) {
		int nums[] = new int[n - 1];
		int index = 0;
		for (int i = 1; i < n; i++) {
			nums[index++] = i;
		}
		int sum = n;
		int n1 = nums.length;
		long dp[][] = new long[sum + 1][n1 + 1];
		for (int i = 0; i <= n1; i++) {
			dp[0][i] = 1;
		}
		for (int i = 0; i <= sum; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n1; j++) {
				dp[i][j] = dp[i][j - 1];
				if (nums[j - 1] <= i) {
					dp[i][j] = (dp[i][j] + dp[i - nums[j - 1]][j]) % (1000000007);
				}
			}
		}
		return (int) dp[sum][n1] % (1000000007);
		// your code here
	}

	int countWays2(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {// Outer loop is for the numbers we can use to from the given number
			for (int j = i; j <= n; j++) { // this loop is for the sum or the number given
				dp[j] = (dp[j] + dp[j - i]) % 1000000007;// for example if you are finding number of
				// ways that can form 5 when i=3 then then you need 2 more
				// (5-3=2 resembles with j-i), dp[j]+=dp[j-i] is done as
				// you can complete
				// forming 5 by just adding 3(i) in all the ways how 2(j-i) could be made.
			}
		}
		// your code here
		return dp[n] % 1000000007;
	}
}
