package Graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphUsingDFS {
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recSt) {
		visited[s] = true;
		recSt[s] = true;
		for (int u : adj.get(s)) {
			if (visited[u] == false && DFSRec(adj, u, visited, recSt) == true) {
				return true;
			} else if (recSt[u] == true) {
				return true;
			}
		}
		recSt[s] = false;
		return false;
	}

//Time Complexity : O(V+E) and space complexity O(1)
	static boolean DFS(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		boolean[] recSt = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				if (DFSRec(adj, i, visited, recSt)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		addEdge(adj, 0, 1);
		addEdge(adj, 2, 1);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);
		addEdge(adj, 5, 3);

		if (DFS(adj, V) == true)
			System.out.println("Cycle found");
		else
			System.out.println("No cycle found");
	}

}
