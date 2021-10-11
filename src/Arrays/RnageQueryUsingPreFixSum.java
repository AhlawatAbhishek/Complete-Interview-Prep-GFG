package Arrays;

public class RnageQueryUsingPreFixSum {
//Time complexity: O(N) and auxiliary space : O(N)	
	public static int[] preSum(int arr[], int n) {
		int preSum[] = new int[n];
		preSum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			preSum[i] = preSum[i - 1] + arr[i];
		}
		return preSum;
	}

//Time complexity: O(1) and auxiliary space: O(1) 
	public static int getSum(int preSum[], int l, int r) {
		if (l == 0) {
			return preSum[r];
		} else {
			return preSum[r] - preSum[l - 1];

		}
	}

	public static void main(String[] args) {
		int arr[] = { 2, 8, 3, 9, 6, 5, 4 }, n = 7;

		int prefix_sum[] = preSum(arr, n);

		System.out.println(getSum(prefix_sum, 1, 3));

		System.out.println(getSum(prefix_sum, 0, 2));

	}

}
