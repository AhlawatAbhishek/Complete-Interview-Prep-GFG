package Arrays;

public class MatrixSnakePattern {
//	Time complexity: 0(n*m) and space complexity: O(1)
	public static void printSnake(int arr[][]) {
		for (int row = 0; row < arr.length; row++) {
			int col = 0;
			if (row % 2 != 0) {
				col = arr[row].length - 1;
				for (; col >= 0; col--) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (; col < arr[row].length; col++) {
					System.out.print(arr[row][col] + " ");
				}
			}
//    	   System.out.println();

		}
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		printSnake(arr);

	}

}
