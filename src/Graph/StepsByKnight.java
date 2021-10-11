package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {
	class Cordinate {
		int x, y, dist;

		Cordinate(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
		// Code here
		boolean visited[][] = new boolean[N][N];
		int board[][] = new int[N][N];
		board[KnightPos[0] - 1][KnightPos[1] - 1] = 2;
		board[TargetPos[0] - 1][TargetPos[1] - 1] = 6;
		int x = KnightPos[0] - 1;
		int y = KnightPos[1] - 1;
		return BFS(board, x, y, visited);
		// return dfs(board, x, y, visited);

	}

	int BFS(int[][] board, int x, int y, boolean[][] visited) {
		Queue<Cordinate> queue = new LinkedList<>();
		queue.add(new Cordinate(x, y, 0));
		int dirX[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
		int dirY[] = { -1, 1, -1, 1, 2, -2, 2, -2 };
		while (!queue.isEmpty()) {
			Cordinate curr = queue.poll();
			if (board[curr.x][curr.y] == 6) {
				return curr.dist;
			}
			for (int i = 0; i < 8; i++) {
				int xNew = curr.x + dirX[i];
				int yNew = curr.y + dirY[i];
				if (isSafe(xNew, yNew, board) && !visited[xNew][yNew]) {
					visited[xNew][yNew] = true;
					queue.add(new Cordinate(xNew, yNew, curr.dist + 1));
				}

			}
		}
		return -1;
	}

	boolean isSafe(int x, int y, int[][] board) {
		if (x < 0 || x >= board.length || y >= board[0].length || y < 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
