package Arrays;

public class RotateAnticlockWiseNinty {
//	Time complexity: O(N^2) and auxiliary space: O(1) 
	public static void rotate90(int arr[][]) {
		transpose(arr);
		int top = 0, bottom = arr.length - 1;
		while (top < bottom) {
			for (int i = 0; i < arr[0].length; i++) {
				swapRows(arr, top, bottom, i);
			}
			top++;
			bottom--;
		}
	}

//	Time complexity: O(N^2) and auxiliary space: O(N^2) 
	public static void rotate90Naive(int arr[][]) {
		int temp[][] = new int[arr.length][arr[0].length];
		int n = arr.length;
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				temp[n - col - 1][row] = arr[row][col];
			}
		}
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				arr[row][col] = temp[row][col];
			}
		}
	}

	public static void swapRows(int arr[][], int row1, int row2, int col) {
		int temp = arr[row1][col];
		arr[row1][col] = arr[row2][col];
		arr[row2][col] = temp;
	}

	public static void transpose(int arr[][]) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = row + 1; col < arr[0].length; col++) {
				swap(arr, row, col);
			}
		}
	}

	public static void swap(int arr[][], int row, int col) {
		int temp = arr[row][col];
		arr[row][col] = arr[col][row];
		arr[col][row] = temp;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

//		rotate90(arr);
		rotate90Naive(arr);
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}

			System.out.println();
		}

	}

}
