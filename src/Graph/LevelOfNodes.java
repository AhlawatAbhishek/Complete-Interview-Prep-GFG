package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfNodes {
//	start from node 0
	int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
		// code here
		boolean visited[] = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int level[] = new int[V];
		level[0] = 0;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			if (u == X) {
				return level[u];
			}

			for (int v : adj.get(u)) {
				if (!visited[v]) {
					level[v] = level[u] + 1;
					if (v == X) {
						return level[v];
					}
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
