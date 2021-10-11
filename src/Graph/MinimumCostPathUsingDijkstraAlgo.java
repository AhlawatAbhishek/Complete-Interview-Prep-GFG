package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Given a square grid of size N, each cell of which contains integer cost
 *  which represents a cost to traverse through that cell, we need to find
 *   a path from top left cell to bottom right cell by which the total cost
 *    incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j). 

Note: It is assumed that negative cost cycles do not exist in the input matrix.


Example 1:

Input: grid = {{9,4,9,9},{6,7,6,4},
{8,3,3,7},{7,4,9,10}}
Output: 43
Explanation: The grid is-
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10
The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
 * */
public class MinimumCostPathUsingDijkstraAlgo {
	static class Cordinates {
		int x, y, dist;

		Cordinates(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static int minimumCostPath(int[][] grid) {
		// Code here
		int row = grid.length;
		int col = grid[0].length;
		int distance[][] = new int[row][col];
		for (int a[] : distance) {
			Arrays.fill(a, Integer.MAX_VALUE);
		}

		// Arrays.fill(distance, Integer.MAX_VALUE); -> this will not work for 2d array
		// for 2d array :
		/*
		 * for(int a[] : distance){ Arrays.fill(a, Integer.MAX_VALUE); }
		 */
		distance[0][0] = grid[0][0];
		PriorityQueue<Cordinates> queue = new PriorityQueue<>(row * col, (a, b) -> a.dist - b.dist);
		queue.add(new Cordinates(0, 0, grid[0][0]));
		int dirX[] = { 0, 0, -1, 1 };
		int dirY[] = { -1, 1, 0, 0 };
		while (!queue.isEmpty()) {
			Cordinates curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				int xNew = curr.x + dirX[i];
				int yNew = curr.y + dirY[i];
				if (isSafe(grid, xNew, yNew) && distance[xNew][yNew] > distance[curr.x][curr.y] + grid[xNew][yNew]) {
					if (distance[xNew][yNew] != Integer.MAX_VALUE) {
						Cordinates cor = new Cordinates(xNew, yNew, distance[xNew][yNew]);
						queue.remove(cor);
					}
					distance[xNew][yNew] = distance[curr.x][curr.y] + grid[xNew][yNew];
					Cordinates corNew = new Cordinates(xNew, yNew, distance[xNew][yNew]);
					queue.add(corNew);
				}
			}
		}
		return distance[row - 1][col - 1];
	}

	public static boolean isSafe(int[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { { 9, 4, 9, 9 }, { 6, 7, 6, 4 }, { 8, 3, 3, 7 }, { 7, 4, 9, 10 } };
		System.out.println("Minimum path cost from top left to bottom right is : " + minimumCostPath(grid));
	}

}
