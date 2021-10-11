
package SegmenTrees;

public class UpdateAndRangeQuery {
//Time complexity: O(N) and auxiliary space : 0(1)
	public static int getSum(int arr[], int left, int right) {
		int sum = 0;
		for (int i = left; i <= right; i++) {
			sum += arr[i];
		}
		return sum;
	}

//Time complexity : O(1) and auxiliary space : 0(1) 
	public static void update(int arr[], int index, int value) {
		arr[index] = value;
	}

	// Time complexity : O(1) and auxiliary space : 0(1)
	public static int getSum1(int preS[], int left, int right) {
		if (left == 0) {
			return preS[right];
		} else {
			return preS[right] - preS[left - 1];
		}
	}

//Time complexity: O(N) and auxiliary space : 0(1)
	public static void update1(int preS[], int arr[], int index, int val, int n) {
		int diff = val - arr[index];
		for (int i = index; i < n; i++) {
			preS[i] += diff;
		}
	}

	public static void initialize(int preS[], int arr[], int n) {
		preS[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			preS[i] = preS[i - 1] + arr[i];
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 }, n = 5;
		int pre_sum[] = new int[n];

		initialize(pre_sum, arr, n);

		System.out.print(getSum1(pre_sum, 0, 2) + " ");
		System.out.print(getSum1(pre_sum, 1, 3) + " ");

		update1(pre_sum, arr, 1, 60, n);

		System.out.print(getSum1(pre_sum, 0, 2) + " ");
		System.out.print(getSum1(pre_sum, 1, 3) + " ");
//		System.out.println(getSum(arr, 0, 2) + " ");
//		System.out.println(getSum(arr, 1, 3) + " ");
//
//		update(arr, 1, 60);
//
//		System.out.println(getSum(arr, 0, 2) + " ");
//		System.out.println(getSum(arr, 1, 3) + " ");

	}

}
