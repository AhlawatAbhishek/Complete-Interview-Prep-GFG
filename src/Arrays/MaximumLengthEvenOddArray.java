package Arrays;

public class MaximumLengthEvenOddArray {
//	Time complexity: O(N^2) and auxiliary space : O(1)
	public static int maxEvenOdd(int arr[], int n) {
		int maxLen = 1;
		for (int i = 0; i < n; i++) {
			int len = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[j] % 2 != 0 && arr[j - 1] % 2 == 0) || (arr[j] % 2 == 0 && arr[j - 1] % 2 != 0)) {
					len++;
				} else {
					break;
				}
			}
			maxLen = Math.max(len, maxLen);
		}
		return maxLen;
	}

//Time complexity: O(N) and auxiliary space: O(1)
	public static int maxEvenOdd1(int arr[], int n) {
		int maxLen = 1, currLen = 1;
		;
		for (int i = 1; i < n; i++) {
			if ((arr[i] % 2 != 0 && arr[i - 1] % 2 == 0) || (arr[i] % 2 == 0 && arr[i - 1] % 2 != 0)) {
				currLen++;
				maxLen = Math.max(currLen, maxLen);
			} else {
				currLen = 1;
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 10, 20, 6, 3, 8 }, n = 6;

		System.out.println(maxEvenOdd1(arr, n));

	}

}
