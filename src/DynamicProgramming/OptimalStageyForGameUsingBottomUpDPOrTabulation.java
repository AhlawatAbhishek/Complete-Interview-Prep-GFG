package DynamicProgramming;

public class OptimalStageyForGameUsingBottomUpDPOrTabulation {
//time complexity : theta(N*N) and space complexity or auxiliary space : theta(N*N)
	static int sol(int arr[], int n) {
		int dp[][] = new int[n][n];
		for (int i = 0; i < n - 1; i++) {
			dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
		}
		for (int gap = 3; gap < n; gap = gap + 2) {
			for (int i = 0; i + gap < n; i++) {
				int j = gap + i;

				dp[i][j] = Math.max((arr[i] + Math.min(dp[i + 1][j], dp[i + 1][j - 1])),
						(arr[i] + Math.min(dp[i + 1][j - 1], dp[i][j - 2])));
			}
		}

		return dp[0][n - 1];
	}

//this is correct code for even odd length array;
	static long countMaximum(int arr[], int n) {
		// Your code here
		long dp[][] = new long[n][n];
		for (int g = 0; g < n; g++) {
			for (int i = 0, j = g; j < n; i++, j++) {
				if (g == 0)
					dp[i][j] = arr[i];
				else if (g == 1)
					dp[i][j] = Math.max(arr[i], arr[j]);
				else {
					long val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
					long val2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
					dp[i][j] = Math.max(val1, val2);
				}
			}
		}

		return dp[0][n - 1];
		// int sum = 0;
		// for(int i : arr){
		// sum += i;
		// }
		// return returnMax(arr,sum, 0, arr.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;

		int arr[] = { 20, 5, 4, 6 };

		System.out.println(sol(arr, n));
	}

}
