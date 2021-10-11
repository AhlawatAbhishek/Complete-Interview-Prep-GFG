package Graph;

import java.util.ArrayList;

public class PossiblePathBetweenTwoVertices {
	int res = 0;

	public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source, int destination) {
		// Code here
		boolean visited[] = new boolean[V];
		DFSRecur(adj, visited, source, destination);
		return res;
	}

	public void DFSRecur(ArrayList<ArrayList<Integer>> adj, boolean visited[], int src, int dest) {
		visited[src] = true;

		if (src == dest) {
			res++;
		}
		for (int v : adj.get(src)) {
			DFSRecur(adj, visited, v, dest);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
