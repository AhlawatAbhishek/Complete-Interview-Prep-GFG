package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortUsingDFS {
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}

	static void DFS(ArrayList<ArrayList<Integer>> adj, int u, Stack<Integer> st, boolean visited[]) {
		visited[u] = true;
		for (int v : adj.get(u)) {
			if (visited[v] == false) {
				DFS(adj, v, st, visited);
			}
		}
		st.push(u);
	}

//Time complexity: O(V+E) and space complexity: O(V)
	static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFS(adj, i, st, visited);
			}
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		addEdge(adj, 0, 1);
		addEdge(adj, 1, 3);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 2, 4);

		System.out.println("Following is a Topological Sort of");
		topologicalSort(adj, V);
	}

}
