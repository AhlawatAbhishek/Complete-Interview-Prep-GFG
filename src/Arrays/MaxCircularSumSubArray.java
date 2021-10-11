package Arrays;

public class MaxCircularSumSubArray {
//	Time complexity: O(N^2) and auxiliary space: 0(1)
	public static int maxCircularSum(int arr[], int n) {
		int res = arr[0];
		for (int i = 0; i < n; i++) {
			int currMax = arr[i];
			int sum = arr[i];
			for (int j = 1; j < n; j++) {
				int index = (i + j) % n;
				sum += arr[index];
				currMax = Math.max(currMax, sum);
			}
			res = Math.max(res, currMax);
		}
		return res;

	}

//	Time complexity: 0(N) and auxiliary space: 0(1)
	public static int maxSubSum(int arr[], int n) {
		int maxSum = arr[0], prevMax = arr[0];
		for (int i = 1; i < n; i++) {
			prevMax = Math.max(prevMax + arr[i], arr[i]);
			maxSum = Math.max(prevMax, maxSum);
		}
		return maxSum;
	}

	public static int maxCircularSum1(int arr[], int n) {
		int maxNormalSum = maxSubSum(arr, n);
		if (maxNormalSum < 0) {
			return maxNormalSum;
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			arr[i] = -arr[i];
		}
		int modifiedSum = maxSubSum(arr, n);
		int circSum = sum + modifiedSum;
		return Math.max(maxNormalSum, circSum);
	}

	public static void main(String[] args) {
		int arr[] = { 5, -2, 3, 4 }, n = 4;

		System.out.println(maxCircularSum1(arr, n));

	}

}
