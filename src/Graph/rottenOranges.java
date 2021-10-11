package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a grid of dimension nxm where each cell in the grid 
 * can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges.
 A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j],
 [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 * */

/*
 * Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
 * */
public class rottenOranges {
	public int orangesRotting(int[][] grid) {
		// Code here
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					grid[i][j] = -1;
				}
			}
		}
		int matrix[][] = updateMatrix(grid);
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == -1) {
					return -1;
				}
				max = Math.max(max, matrix[i][j]);
			}
		}
		return max;
	}

	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 2) {
					q.offer(new int[] { i, j });
					visited[i][j] = true;
					matrix[i][j] = 0;
				}
			}
		}
		final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int curr[] = q.poll();
				int currX = curr[0];
				int currY = curr[1];
				for (int[] dir : dirs) {
					int x = currX + dir[0];
					int y = currY + dir[1];
					if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || visited[x][y] || matrix[x][y] == 0) {
						continue;
					}
					matrix[x][y] = matrix[currX][currY] + 1;
					q.offer(new int[] { x, y });
					visited[x][y] = true;
				}
			}
		}
		return matrix;
	}

	public static void main(String[] args) {

	}

}
