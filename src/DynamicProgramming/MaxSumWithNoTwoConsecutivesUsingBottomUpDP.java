package DynamicProgramming;

public class MaxSumWithNoTwoConsecutivesUsingBottomUpDP {
//Time Complexity : theta(N) and auxiliary space or space complexity : theta(N)	
	static int maxSum(int arr[], int n) {
		if (n == 0) {
			return arr[0];
		}
		int dp[] = new int[n + 1];
		dp[1] = arr[0];
		dp[2] = Math.max(arr[0], arr[1]);
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 5, 15, 20 };
		int n = arr.length;
		System.out.println(maxSum(arr, n));
	}

}
