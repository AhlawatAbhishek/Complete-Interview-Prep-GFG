package Arrays;

public class TransposeOfAMatrix {

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
		int n = arr.length;
		transpose(arr);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
