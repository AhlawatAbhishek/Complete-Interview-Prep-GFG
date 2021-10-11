package BackTracking;

public class NQueensProblem {

	public static void printBoard(int board[][]) {
		for (int i[] : board) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static boolean isSafe(int[][] board, int r, int col) {
		int row = board.length;
//		for checking in row from left to current col;
		for (int i = 0; i < col; i++) {
			if (board[r][i] == 1) {
				return false;
			}
		}
//		for checking in left upper diagonal
		for (int i = r, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
//		for checking in left lower diagonal
		for (int i = r, j = col; j >= 0 && i < row; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	public static boolean solveRec(int[][] board, int col) {
		if (col == board.length) {
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;

				if (solveRec(board, col + 1) == true)
					return true;

				board[i][col] = 0;
			}
		}
		return false;
	}

//Time Complexity: O(N!) and space complexity: O(N^2) if board is not given and O(N)
//	if board is given
	public static void solveBorad(int[][] board, int N) {
		if (!solveRec(board, 0)) {
			System.out.println("Solution doesnot exits");
			return;
		}
		printBoard(board);
	}

	public static void main(String[] args) {
//		int N = 4;
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		solveBorad(board, 0);
	}

}
