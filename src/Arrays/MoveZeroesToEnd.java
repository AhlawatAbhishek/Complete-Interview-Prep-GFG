package Arrays;

public class MoveZeroesToEnd {
	// Time complexity: O(N) and auxiliary space : O(N)
	public static void moveZeroToEnd(int arr[], int n) {
		int zero = 0;
		int[] copy = new int[n];
		for (int i : arr) {
			if (i == 0) {
				zero++;
			}
		}
		if (zero == n) {
			return;
		}
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0)
				copy[index++] = arr[i];
		}
		for (int i = 0; i < n; i++) {
			arr[i] = copy[i];
		}
	}

	// Time complexity: O(N^2) and auxiliary space : O(1)
	public static void moveZeroToEndNaive(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				for (int j = i + 1; j < n; j++) {
					if (arr[j] != 0) {
						swap(arr, i, j);
						break;
					}
				}
			}

		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Time complexity: O(N) and auxiliary space : O(1)
	public static void moveZeroToEnd3(int arr[], int n) {
		int nonZero = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				swap(arr, nonZero, i);
				nonZero++;
			}
		}

	}

	public static void main(String[] args) {
		int arr[] = { 8, 5, 0, 10, 0, 20 };
//		moveZeroToEnd(arr, arr.length);
		moveZeroToEndNaive(arr, arr.length);
//		moveZeroToEnd3(arr, arr.length);
		System.out.println("Moving zeroes to end");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
