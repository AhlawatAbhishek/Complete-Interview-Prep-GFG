package DynamicProgramming;

public class SticlerTheifUsingRecursionAndBottomUpDpOrTabulation {
	/*
	 * Stickler the thief wants to loot money from a society having n houses in a
	 * single line. He is a weird person and follows a certain rule when looting the
	 * houses. According to the rule, he will never loot two consecutive houses. At
	 * the same time, he wants to maximize the amount he loots. The thief knows
	 * which house has what amount of money but is unable to come up with an optimal
	 * looting strategy. He asks for your help to find the maximum money he can get
	 * if he strictly follows the rule. Each house has a[i] amount of money present
	 * in it
	 */
	public int FindMaxSum(int arr[], int n) {
		// Your code here
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = arr[0];
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i - 1], dp[i - 1]);
		}
		return dp[n];
		// return findMaxAmount(arr, 0, false, 0);
	}

	int findMaxAmount(int arr[], int index, boolean prev, int sum) {
		if (index >= arr.length) {
			return sum;
		}
		int res = Integer.MIN_VALUE;
		if (!prev) {
			res = findMaxAmount(arr, index + 1, prev, sum);
			res = Math.max(res, findMaxAmount(arr, index + 1, true, sum + arr[index]));
		} else {
			res = findMaxAmount(arr, index + 1, false, sum);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
