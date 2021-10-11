package BackTracking;

public class RateInMazeWithMultipleJumps {
	/*
	 * A Maze is given as N*N matrix of blocks where source block is the upper left
	 * most block i.e., maze[0][0] and destination block is lower rightmost block
	 * i.e., maze[N-1][N-1]. Find the minimum number of Hops required for the rat to
	 * reach from the source block to the destination block. The number of steps rat
	 * can jump from (i, j) is represented by maze[i][j].
	 * 
	 * Note: If multiple solutions exist, the shortest earliest hop will be
	 * accepted. For the same hop distance at any point, forward will be preferred
	 * over downward. In the maze matrix, 0 means the block is the dead end and
	 * non-zero number means the block can be used in the path from source to
	 * destination. The non-zero value of mat[i][j] indicates number of maximum
	 * jumps rat can make from cell mat[i][j].
	 * 
	 * Example 1:
	 * 
	 * Input: N = 4 maze[][] = {{2,1,0,0},{3,0,0,1}, {0,1,0,1},{0,0,0,1}} Output: 1
	 * 0 0 0 1 0 0 1 0 0 0 1 0 0 0 1 Explanation: Rat started with m[0][0] and can
	 * jump up to 2 steps right/down. First check m[0][1] as it is 1, next check
	 * m[0][2], this won't lead to the solution. Then check m[1][0], as this is
	 * 3(non-zero) so we can make 3 jumps to reach m[1][3]. From m[1][3] we can move
	 * downwards taking 1 jump each time to reach destination at m[3][3].
	 */
	public static void solve(int[][] a, int N) {
		int[][] arr = new int[N][N];
		boolean result = find(a, 0, 0, N, arr);
		if (result) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		} else
			System.out.println(-1);
	}

	public static boolean isOk(int[][] a, int row, int col, int n) {
		return row >= 0 && col >= 0 && row < n && col < n && a[row][col] != 0;
	}

	public static boolean find(int[][] a, int row, int col, int n, int[][] arr) {

		if (row == n - 1 && col == n - 1) {
			arr[row][col] = 1;
			return true;
		}
		if (isOk(a, row, col, n) == true) {
			arr[row][col] = 1;
			for (int m = 1; m <= a[row][col]; m++) {

				if (find(a, row, col + m, n, arr) == true)
					return true;
				if (find(a, row + m, col, n, arr) == true)
					return true;
			}
			arr[row][col] = 0;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
