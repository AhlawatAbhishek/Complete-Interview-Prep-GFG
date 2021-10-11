package Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {

	static class AdjListNode {
		private int v;
		private int weight;

		AdjListNode(int v, int w) {
			this.v = v;
			this.weight = w;
		}

		int getV() {
			return v;
		}

		int getWeight() {
			return weight;
		}
	}

	private int V;
	private LinkedList<AdjListNode> adj[];

	ShortestPathInDirectedAcyclicGraph(int v) {
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<AdjListNode>();
		}
	}

	void addEdge(int u, int v, int weight) {
		AdjListNode node = new AdjListNode(v, weight);
		adj[u].add(node);
	}

	void topologicalSortUitl(int v, boolean visited[], Stack<Integer> stack) {
		visited[v] = true;
		Integer i;
		Iterator<AdjListNode> it = adj[v].iterator();
		while (it.hasNext()) {
			AdjListNode node = it.next();
			if (!visited[node.getV()]) {
				topologicalSortUitl(node.getV(), visited, stack);
			}
		}
		stack.add(v);
	}

//Time complexity : O(V+E) and space complexity : O(1)
	void shortestPath(int s) {
		Stack<Integer> stack = new Stack<>();
		int dist[] = new int[V];
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			topologicalSortUitl(i, visited, stack);
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		while (!stack.isEmpty()) {
			int u = (int) stack.pop();
			Iterator<AdjListNode> it;
			if (dist[u] != Integer.MAX_VALUE) {
				it = adj[u].iterator();
				while (it.hasNext()) {
					AdjListNode i = it.next();
					if (dist[i.getV()] > dist[u] + i.getWeight()) {
						dist[i.getV()] = dist[u] + i.getWeight();
					}
				}
			}
		}
		for (int i = 0; i < V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.print("INF");
			} else {
				System.out.print(dist[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestPathInDirectedAcyclicGraph g = new ShortestPathInDirectedAcyclicGraph(6);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 4, 1);
		g.addEdge(1, 2, 3);
		g.addEdge(4, 2, 2);
		g.addEdge(4, 5, 4);
		g.addEdge(2, 3, 6);
		g.addEdge(5, 3, 1);

		int s = 0;
		System.out.println("Following are shortest distances " + "from source " + s);
		g.shortestPath(s);
	}

}
