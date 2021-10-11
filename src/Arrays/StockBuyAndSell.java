package Arrays;

public class StockBuyAndSell {
//	Time complexity : O(N) and auxiliary space : O(1)
	public static int maxProfit2(int price[], int start, int end) {
		int profit = 0;
		for (int i = start + 1; i <= end; i++) {
			if (price[i] > price[i - 1]) {
				profit += price[i] - price[i - 1];
			}
		}
		return profit;

	}

//	Time complexity : O(N^3) and auxiliary space : O(1)
	public static int maxProfit(int price[], int start, int end) {
		if (end <= start) {
			return 0;
		}
		int profit = 0;
		for (int i = start; i <= end; i++) {
			for (int j = i + 1; j <= end; j++) {
				if (price[i] < price[j]) {
					int currProfit = price[j] - price[i] + maxProfit(price, start, i - 1)
							+ maxProfit(price, j + 1, end);
					profit = Math.max(profit, currProfit);
				}
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 3, 8, 12 }, n = 5;

		System.out.println(maxProfit2(arr, 0, n - 1));

	}

}
