package Arrays;

public class TrappingRainWater {
//	Time complexity : 0(N^2) and auxiliary space : 0(1)
	public static int getWater(int arr[], int n) {
		int maxWater = 0;
		for (int i = 1; i < n - 1; i++) {
			int lMax = arr[i], rMax = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				lMax = Math.max(lMax, arr[j]);
			}
			for (int j = i + 1; j < n; j++) {
				rMax = Math.max(rMax, arr[j]);
			}
			maxWater += Math.min(lMax, rMax) - arr[i];
		}
		return maxWater;
	}

//	Time complexity : 0(N) and auxiliary space : 0(N)
	public static int getWater1(int arr[], int n) {
		int maxWater = 0;
		int[] lMax = new int[n];
		int[] rMax = new int[n];
		lMax[0] = arr[0];
		rMax[n - 1] = arr[n - 1];
		for (int i = 1; i < n; i++) {
			lMax[i] = Math.max(lMax[i - 1], arr[i]);
		}
		for (int i = n - 2; i >= 0; i--) {
			rMax[i] = Math.max(rMax[i + 1], arr[i]);
		}
		for (int i = 0; i < n; i++) {
			maxWater += Math.min(lMax[i], rMax[i]) - arr[i];
		}
		return maxWater;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 0, 1, 2, 5 }, n = 5;

		System.out.println(getWater1(arr, n));
	}

}
