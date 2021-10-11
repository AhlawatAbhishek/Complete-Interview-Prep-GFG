package Arrays;

public class SearchInARowWiseAndColumnWiseSortedMatrix {
//	Time complexity : O(N+M) and auxiliary space: O(1)
	public static int[] search(int arr[][], int key) {
		int n = arr.length, m = arr[0].length, row = 0, col = m - 1;
		while (row < n && col >= 0) {
			if (arr[row][col] == key) {
				return new int[] { row, col };
			} else if (arr[row][col] < key) {
				row++;
			} else if (arr[row][col] > key) {
				col--;
			}
		}
		return new int[] { -1, -1 };
	}

//	Time complexity : O(N*M) and auxiliary space: O(1)
	static void search1(int mat[][], int x) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == x) {
					System.out.println("Found at (" + i + ", " + j + ")");

					return;
				}
			}
		}

		System.out.println("Not Found");
	}

	public static void main(String[] args) {
		int arr[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 35, 45 }, { 32, 33, 39, 50 } };
		int x = 29;

//		int res[] = search(arr, x);
//		System.out.println("Found At: " + res[0] + "," + res[1]);
		search1(arr, x);

	}

}
