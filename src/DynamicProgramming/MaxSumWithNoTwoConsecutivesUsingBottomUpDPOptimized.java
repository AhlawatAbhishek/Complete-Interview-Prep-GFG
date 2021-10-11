package DynamicProgramming;

public class MaxSumWithNoTwoConsecutivesUsingBottomUpDPOptimized {
//    time complexity : theta: O(N) and space complexity: O(1)
	static int maxSum(int arr[], int n) {
		if (n == 0) {
			return arr[0];
		}
		int prev_prev = arr[0];
		int prev = Math.max(arr[0], arr[1]);
		int res = prev;
		for (int i = 3; i <= n; i++) {
			res = Math.max(prev, prev_prev + arr[i - 1]);
			prev_prev = prev;
			prev = res;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5, arr[] = { 10, 20, 30, 40, 50 };
		System.out.println(maxSum(arr, n));
	}

}
