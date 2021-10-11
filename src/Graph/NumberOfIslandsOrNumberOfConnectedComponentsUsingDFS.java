package Graph;

import java.util.ArrayList;

public class NumberOfIslandsOrNumberOfConnectedComponentsUsingDFS {
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		visited[s] = true;

		for (int u : adj.get(s)) {
			if (visited[u] == false)
				DFSRec(adj, u, visited);
		}
	}

	static int DFS(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		int count = 0;
		for (int i = 0; i < V; i++)
			visited[i] = false;

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				DFSRec(adj, i, visited);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 2);
		addEdge(adj, 3, 4);

		System.out.println("Number of connected components: " + DFS(adj, V));
	}
}

//These below are personal solutions of number of islands problems
class Solution {
	public int numIslands(char[][] grid) {
		// Code here
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int countIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					countIslands += dfs(grid, i, j);
				}
			}
		}
		return countIslands;
	}

	public int dfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
			return 0;
		}
		grid[i][j] = '0';
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
		dfs(grid, i + 1, j + 1);
		dfs(grid, i - 1, j - 1);
		dfs(grid, i + 1, j - 1);
		dfs(grid, i - 1, j + 1);
		return 1;
	}
}

class Solutionsss {

	public int numIslands(char[][] grid) {
		// Code here
		int count = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (visited[i][j] != true && grid[i][j] == '1') {
					DFS(grid, visited, i, j);
					count++;
				}
			}

		}
		return count;
	}

	void DFS(char arr[][], boolean[][] visited, int row, int col) {
		if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length
				|| (arr[row][col] == '0' || visited[row][col])) {
			return;
		}
		visited[row][col] = true;
		DFS(arr, visited, row + 1, col + 1);
		DFS(arr, visited, row, col + 1);
		DFS(arr, visited, row + 1, col);
		DFS(arr, visited, row - 1, col - 1);
		DFS(arr, visited, row, col - 1);
		DFS(arr, visited, row - 1, col);
		DFS(arr, visited, row + 1, col - 1);
		DFS(arr, visited, row - 1, col + 1);

	}
}
