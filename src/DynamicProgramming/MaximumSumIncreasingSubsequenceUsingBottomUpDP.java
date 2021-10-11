package DynamicProgramming;

public class MaximumSumIncreasingSubsequenceUsingBottomUpDP {
	// Time complexity: theta(N^2) and space complexity : theta(N)
	static int MSIS(int arr[], int n) {
		int[] msis = new int[n];
		for (int i = 0; i < msis.length; i++) {
			msis[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					msis[i] = Math.max(msis[i], arr[i] + msis[j]);
				}
			}
		}
		int res = msis[0];
		for (int i = 1; i < msis.length; i++) {
			res = Math.max(res, msis[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;

		int arr[] = { 5, 10, 20 };

		System.out.println(MSIS(arr, n));

	}

}
