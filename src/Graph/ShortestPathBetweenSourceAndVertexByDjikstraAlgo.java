package Graph;

import java.util.Arrays;

public class ShortestPathBetweenSourceAndVertexByDjikstraAlgo {

	static final int V = 4;

	// Time complexity : theta(V*V) and space complexity(Auxillary Space): O(1)
//	if this method were implimented using minHeap then time complexity: O((v+e) log v) 
//	and space complexity : whatever minHeap takes i guess O(V)
	public static int[] djikstra(int graph[][], int src) {
		int[] dist = new int[V];
		int res = 0;
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		boolean[] fin = new boolean[V];
		for (int count = 0; count < V - 1; count++) {
			int u = -1;
			for (int i = 0; i < V; i++) {
				if (!fin[i] && (u == -1 || dist[i] < dist[u])) {
					u = i;
				}
			}
			fin[u] = true;
			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && fin[v] == false) {
					dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = new int[][] { { 0, 50, 100, 0 }, { 50, 0, 30, 200 }, { 100, 30, 0, 20 }, { 0, 200, 20, 0 }, };

		for (int x : djikstra(graph, 0)) {
			System.out.print(x + " ");
		}
	}

}
