package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BridgesInGraph {
	private int V;

	private LinkedList<Integer> adj[];
	int time = 0;
	static final int NIL = -1;

	BridgesInGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {

		visited[u] = true;

		disc[u] = low[u] = ++time;

		Iterator<Integer> i = adj[u].iterator();
		while (i.hasNext()) {
			int v = i.next();

			if (!visited[v]) {
				parent[v] = u;
				bridgeUtil(v, visited, disc, low, parent);

				low[u] = Math.min(low[u], low[v]);

				if (low[v] > disc[u])
					System.out.println(u + " " + v);
			}

			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}

	void bridge() {
		boolean visited[] = new boolean[V];
		int disc[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];

		for (int i = 0; i < V; i++) {
			parent[i] = NIL;
			visited[i] = false;
		}

		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				bridgeUtil(i, visited, disc, low, parent);
	}

	public static void main(String args[]) {
		System.out.println("Bridges in first graph ");
		BridgesInGraph g = new BridgesInGraph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		g.bridge();
	}

}

//class Solution {
//    /*
//    V : number of vertices 1 to v
//    adj : the input graph
//    c,d : End vertices of the given edge , you have to tell if c and d are bridge or not
//     return 1 if edge cd is bridge and 0 otherwise
//    */
// 
//    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int s, int e) {
//        // code here
//        for(int i = 0; i<adj.get(s).size(); i++){
//            if(adj.get(s).get(i) == e){
//                adj.get(s).remove(i);   
//            }
//        } 
//         for(int i = 0; i<adj.get(e).size(); i++){
//            if(adj.get(e).get(i) == s){
//                adj.get(e).remove(i);   
//            }
//        }
//        boolean[] visited = new boolean[V+1];
//    
//           dfs(adj, visited, s);
//   
//        if(visited[e])
//           return 0;
//        else
//           return 1;
//    }
//    public static void dfs( ArrayList<ArrayList<Integer>> adj, boolean [] visited, int v){
//             visited[v] = true;
//       
//             for(int u : adj.get(v)){
//                if(!visited[u]){
//                
//                 dfs(adj, visited, u);
//                
//                 }
//               
//             }
//            
//    }
//        
//        
//}
