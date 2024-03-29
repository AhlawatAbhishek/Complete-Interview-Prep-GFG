package GreedyAlgorithm;

import java.util.Arrays;

public class MinimumCoinsToMakeASum {
//	Time complexity : O(N) and space complexity: O(1)
	static int minCoins(int coin[], int n, int amount) {
		Arrays.sort(coin);
		int res = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (coin[i] <= amount) {
				int c = (int) Math.floor(amount / coin[i]);
				res = res + c;
				amount = amount - c * coin[i];
			}
			if (amount == 0) {
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coin[] = { 5, 10, 2, 1 }, n = 4, amount = 57;
		System.out.println(minCoins(coin, n, amount));
	}

}
