package Arrays;

public class SpiralTraversalMatrix {
//	Time complexity: O(N*M) and auxiliary space : O(1)
	public static void printSpiral(int arr[][], int n, int m) {
		int top = 0, bottom = n - 1, left = 0, right = m - 1;
		int dir = 0;
		while (top <= bottom && right >= left) {
			if (dir == 0) {
				for (int col = left; col <= right; col++) {
					System.out.print(arr[top][col] + " ");
				}
				top++;
				dir = 1;
			} else if (dir == 1) {
				for (int row = top; row <= bottom; row++) {
					System.out.print(arr[row][right] + " ");
				}
				right--;
				dir = 2;
			} else if (dir == 2) {
				for (int col = right; col >= left; col--) {
					System.out.print(arr[bottom][col] + " ");
				}
				bottom--;
				dir = 3;
			} else if (dir == 3) {
				for (int row = bottom; row >= top; row--) {
					System.out.print(arr[row][left] + " ");
				}
				left++;
				dir = 0;
			}
		}
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		printSpiral(arr, 4, 4);

	}

}
