package BackTracking;

public class RateInMaze {
//	Time complexity: O(2^n) and space complexity : O(n^2) for sol matrix for result
	public static boolean isPossibleToEatCheese(int[][] grid, int row, int col, boolean[][] visited, int sol[][]) {

		if (row == grid.length - 1 && col == grid[0].length - 1 && grid[row][col] == 1) {
			sol[row][col] = 1;
			return true;
		}
		if (isSafe(grid, row, col, visited)) {
			visited[row][col] = true;
			sol[row][col] = 1;
			if (isPossibleToEatCheese(grid, row + 1, col, visited, sol))
				return true;
			if (isPossibleToEatCheese(grid, row, col + 1, visited, sol))
				return true;
			sol[row][col] = 0;
		}

		return false;
	}

	public static boolean isSafe(int[][] grid, int row, int col, boolean visited[][]) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]
				|| grid[row][col] == 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		int[][] sol = new int[maze.length][maze[0].length];
		boolean isPossible = isPossibleToEatCheese(maze, 0, 0, visited, sol);
		System.out.println(isPossible);
		if (isPossible) {
			for (int i[] : sol) {
				for (int z : i) {
					System.out.print(z + " ");
				}
				System.out.println();
			}
		}
	}

}
