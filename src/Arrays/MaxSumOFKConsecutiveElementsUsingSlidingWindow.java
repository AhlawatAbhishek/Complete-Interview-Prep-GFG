package Arrays;

//For Sliding window Algo to work to check whether target sum is present in array or not
//all the elements should be positive, for negative use hashing
public class MaxSumOFKConsecutiveElementsUsingSlidingWindow {
//	This is naive method also works for the negatives
//	Time complexity : O(N^2) and auxiliary space : 0(1)
	public static int maxSum(int arr[], int n, int k) {
		int max_Sum = Integer.MIN_VALUE;
		for (int i = 0; i < n - k + 1; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += arr[i + j];
			}
			max_Sum = Math.max(max_Sum, sum);
		}
		return max_Sum;
	}

//Time complexity: O(N) and auxiliary space : 0(1)
//	Sliding window Algo
	public static int maxSum1(int arr[], int n, int k) {
		int currSum = 0, maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			currSum += arr[i];
		}
		maxSum = Math.max(currSum, maxSum);
		for (int i = k; i < n; i++) {
			currSum += arr[i] - arr[i - k];
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 8, 30, -5, 20, 7 }, n = 6, k = 3;

		System.out.println(maxSum1(arr, n, k));

	}

}
