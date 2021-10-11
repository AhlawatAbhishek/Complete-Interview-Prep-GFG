package Arrays;

public class MatrixBoundaryTraversal {
//Time complexity: O(N+M) and auxiliary space: O(1)
	public static void bTraversal(int arr[][]) {
		int row = 0, col = 0, rowLen = arr.length, colLen = arr[0].length;
		if (rowLen == 1) {
			for (; col < colLen; col++) {
				System.out.print(arr[row][col] + " ");
			}
		} else if (colLen == 1) {
			for (; row < rowLen; row++) {
				System.out.print(arr[row][col] + " ");
			}
		} else {
			for (; col < colLen; col++) {
				System.out.print(arr[row][col] + " ");
			}

			row++;
			col--;
			for (; row < rowLen; row++) {
				System.out.print(arr[row][col] + " ");
			}

			col--;
			row--;
			for (; col >= 0; col--) {
				System.out.print(arr[row][col] + " ");
			}
			row--;
			col++;
			for (; row >= 1; row--) {
				System.out.print(arr[row][col] + " ");
			}
		}
	}

	// Time complexity: O(N+M) and auxiliary space: O(1)
	static void bTraversal1(int mat[][]) {
		int R = mat.length, C = mat[0].length;
		if (R == 1) {
			for (int i = 0; i < C; i++)
				System.out.print(mat[0][i] + " ");
		} else if (C == 1) {
			for (int i = 0; i < R; i++)
				System.out.print(mat[i][0] + " ");
		} else {
			for (int i = 0; i < C; i++)
				System.out.print(mat[0][i] + " ");
			for (int i = 1; i < R; i++)
				System.out.print(mat[i][C - 1] + " ");
			for (int i = C - 2; i >= 0; i--)
				System.out.print(mat[R - 1][i] + " ");
			for (int i = R - 2; i >= 1; i--)
				System.out.print(mat[i][0] + " ");
		}

	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		bTraversal(arr);
	}

}
