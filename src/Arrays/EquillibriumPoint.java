package Arrays;

public class EquillibriumPoint {
//	Time complexity: O(N^2) and auxiliary space : O(1)
	public static boolean checkEquilibrium(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			int leftSum = 0, rightSum = 0;
			for (int j = 0; j < i; j++) {
				leftSum += arr[j];
			}
			for (int j = i + 1; j < n; j++) {
				rightSum += arr[j];
			}
			if (leftSum == rightSum) {
				return true;
			}
		}
		return false;
	}

//	Time complexity: O(N) and auxiliary space : O(1)
	public static boolean checkEquilibrium1(int arr[], int n) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		int leftSum = 0;
		for (int i = 0; i < n; i++) {
			int rightSum = sum - arr[i];
			if (leftSum == rightSum) {
				return true;
			}
			leftSum += arr[i];
			sum -= arr[i];
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 8, -9, 20, 6 }, n = 6;

		System.out.println(checkEquilibrium1(arr, n));
	}

}
