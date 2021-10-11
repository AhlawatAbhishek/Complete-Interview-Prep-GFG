package Arrays;

public class MaximumSumSubArray {
	// Time complexity: O(N^2) and auxiliary space: O(1)
	public static int maxSum(int arr[], int n) {
		int maxS = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				maxS = Math.max(maxS, sum);
			}
		}
		return maxS;
	}

// Time complexity: O(N) and auxiliary space: O(1)
	public static int maxSum1(int arr[], int n) {
		int maxS = 0, maxPrev = arr[0];
		for (int i = 1; i < n; i++) {
			maxPrev = Math.max(maxPrev + arr[i], arr[i]);
			maxS = Math.max(maxS, maxPrev);
		}
		return maxS;
	}

	public static void main(String[] args) {
		int arr[] = { 1, -2, 3, -1, 2 }, n = 5;

		System.out.println(maxSum(arr, n));

	}

}
