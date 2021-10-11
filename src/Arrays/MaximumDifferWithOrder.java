package Arrays;

//Maximum Difference problem is to find the maximum of arr[j] - arr[i] where j>i.
public class MaximumDifferWithOrder {
//	Time complexity: 0(N^2) and auxiliary space : 0(1)
	public static int maxDiff(int arr[], int n) {
		int mDiff = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[j] - arr[i] > mDiff) {
					mDiff = arr[j] - arr[i];
				}
			}
		}
		return mDiff;
	}

//	Time complexity: 0(N) and auxiliary space : 0(1)
	public static int maxDiff1(int arr[], int n) {
		int minVal = arr[0], res = arr[1] - arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - minVal > res) {
				res = arr[i] - minVal;
			}
			minVal = Math.min(minVal, arr[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 10, 6, 4, 8, 1 }, n = 7;

		System.out.println(maxDiff1(arr, n));

	}

}
