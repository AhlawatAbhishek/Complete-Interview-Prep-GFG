package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectingCycleUsingBFS {
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

//TimeComplexity : O(V+E) and spaceComplexity : space complexity = O(V), since extra array 
//	is needed for visited marking,
//	sum of all  length of all adjc list = 2E
	static boolean BFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		int parent = -1;
		visited[s] = true;
		q.add(s);

		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v : adj.get(u)) {
				if (visited[v] == false) {
					visited[v] = true;
					q.add(v);
				} else if (u != parent) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean BFSDisc(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;

		}
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				if (BFS(adj, i, visited) == true) {
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
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 4);
		addEdge(adj, 4, 5);
		addEdge(adj, 1, 3);
		addEdge(adj, 2, 3);

		if (BFSDisc(adj, V) == true)
			System.out.println("Cycle found");
		else
			System.out.println("No cycle found");
	}

}
