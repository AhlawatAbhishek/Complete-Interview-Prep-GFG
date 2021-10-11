package DynamicProgramming;

public class CoinChangeRecursiveSolution {
	// Time complexity: exponential and space complexity
	static int getCount(int coins[], int n, int sum) {
		if (sum == 0) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}
		int res = getCount(coins, n - 1, sum);
		if (coins[n - 1] <= sum) {
			res = res + getCount(coins, n, sum - coins[n - 1]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = { 1, 2, 3 }, sum = 4, n = 3;

		System.out.println(getCount(coins, n, sum));
	}

}
