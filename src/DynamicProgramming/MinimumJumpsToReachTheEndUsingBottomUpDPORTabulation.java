package DynamicProgramming;

public class MinimumJumpsToReachTheEndUsingBottomUpDPORTabulation {
//	time complexity theta(N^2) and space complexity or auxiliary space theta(N);
	static int minJumps(int arr[], int n) {
		int dp[] = new int[n];
		int i, j;
		dp[0] = 0;
		for (i = 0; i < n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j] && dp[j] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[j] - i);
					break;
				}
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 4, 2, 1, 2, 1 }, n = 6;
		System.out.println(minJumps(arr, n));
	}

}
