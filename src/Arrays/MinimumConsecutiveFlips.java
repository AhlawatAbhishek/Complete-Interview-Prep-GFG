package Arrays;

public class MinimumConsecutiveFlips {
//	Time complexity: 0(N) and auxiliary space : 0(1)
	public static void printGroups(int arr[], int n) {
		for (int i = 1; i < n; i++) {
			if (arr[i] != arr[i - 1]) {
				if (arr[i] != arr[0]) {
					System.out.print("From " + i);
				} else {
					System.out.print(" To " + (i - 1));
					System.out.println();
				}
			}
		}
		if (arr[n - 1] != arr[0]) {
			System.out.println(n - 1);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 0, 0, 1, 1, 0, 0, 1, 1, 0 }, n = 9;

		printGroups(arr, n);

	}

}
