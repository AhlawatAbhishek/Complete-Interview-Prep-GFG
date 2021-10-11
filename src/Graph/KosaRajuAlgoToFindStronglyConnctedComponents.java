package Graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class KosaRajuAlgoToFindStronglyConnctedComponents {

	private int V;
	private LinkedList<Integer> adj[];

	KosaRajuAlgoToFindStronglyConnctedComponents(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<>();
	}

	public void addEdge(int v, int u) {
		adj[v].add(u);
	}

	public void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		int n;
		Iterator<Integer> i = adj[v].iterator();
		while (i.hasNext()) {
			n = i.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}

	KosaRajuAlgoToFindStronglyConnctedComponents getTranspose() {
		KosaRajuAlgoToFindStronglyConnctedComponents g = new KosaRajuAlgoToFindStronglyConnctedComponents(V);
		for (int v = 0; v < V; v++) {
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext()) {
				g.adj[i.next()].add(v);
			}
		}
		return g;
	}

	void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
		visited[v] = true;
		Iterator<Integer> i = adj[v].iterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				fillOrder(n, visited, stack);
			}
		}
		stack.push(new Integer(v));
	}

//Time complexity : O(V+E)
	void printStronglyConnectedComponent() {
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				fillOrder(i, visited, stack);
			}
		}
		KosaRajuAlgoToFindStronglyConnctedComponents gr = getTranspose();
		Arrays.fill(visited, false);
		while (stack.isEmpty() == false) {
			int v = (int) stack.pop();
			if (!visited[v]) {
				gr.DFSUtil(v, visited);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KosaRajuAlgoToFindStronglyConnctedComponents g = new KosaRajuAlgoToFindStronglyConnctedComponents(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);

		System.out.println("Following are strongly connected components " + "in given graph ");
		g.printStronglyConnectedComponent();
	}

}
// public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
//        //code here
//        Stack<Integer> st = new Stack<>();
//        boolean visited[]  = new boolean[V];
//        for(int v = 0; v<V; v++){
//            if(!visited[v])
//              fillOrder(st, visited, v, adj);
//        }
//       ArrayList<ArrayList<Integer>> res =  getTranspose(adj);
//        // ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        Arrays.fill(visited, false);
//        int count = 0;
//       while(!st.isEmpty()){
//           int v = st.pop();
//           if(!visited[v]){
//               count++;
//               dfs(v, visited, res/*, res*/);
//               System.out.println();
//               
//           }
//           
//       }
//         return count;
//    //   return res.size();
//    }
//    public void fillOrder(Stack<Integer> st, boolean visited[], int s, ArrayList<ArrayList<Integer>> adj){
//        visited[s] = true;
//        for(int v : adj.get(s)){
//            if(!visited[v]){
//                fillOrder(st, visited, v, adj);
//            }
//        }
//        st.push(s);
//    }
//    public ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adj){
//        ArrayList<ArrayList<Integer>> newList = new ArrayList<>(adj.size());
//        for(int i = 0; i<newList.size(); i++){
//            newList.add(new ArrayList<Integer>());
//        }
//        for(int i = 0; i<adj.size(); i++){
//            ArrayList<Integer> a = adj.get(i);
//            for(int v : a){
//                //   ArrayList<Integer> li = adj.get(v);
//                //   if(li == null){
//                //       li = new ArrayList<>();
//                //       adj.set(v, li);
//                //   } 
//                //   li.add(i);
//                newList.get(v).add(i);
//            }
//        }
//        return newList;
//    }
//    public void dfs(int s, boolean[] visited, ArrayList<ArrayList<Integer>> adj/*, ArrayList<ArrayList<Integer>> res*/){
//        visited[s] = true;
//        System.out.print(s+" ");
//        for(int v : adj.get(s)){
//            if(!visited[v]){
//                dfs(v, visited, adj);
//            }
//        }
//    }
//class Solution
//{
//     static Stack<Integer> stack;
//    static void dfs(ArrayList<ArrayList<Integer>> list, boolean visited[], int start, Stack<Integer> stack)
//    {
//        visited[start]=true;
//        ArrayList<Integer> temp = list.get(start);
//        for(int i=0; i<temp.size(); i++)
//        {
//            int num=temp.get(i);
//            if(visited[num]==false)
//            {
//                dfs(list,visited,num,stack);
//            }
//        }
//        stack.push(start);
//    }
//    
//    static void reverse(ArrayList<ArrayList<Integer>> revlist, ArrayList<ArrayList<Integer>> list)
//    {
//        for(int i=0; i<list.size(); i++)
//        {
//            for(int j=0; j<list.get(i).size(); j++)
//            {
//                int num = list.get(i).get(j);
//                revlist.get(num).add(i);
//            }
//        }
//    }
//    
//    static void print(ArrayList<ArrayList<Integer>> list )
//    {
//        for(int i=0 ;i<list.size(); i++)
//        {
//            System.out.print(i+"-> ");
//            for(int j=0; j<list.get(i).size() ;j++)
//            {
//                System.out.print(list.get(i).get(j)+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//    
//    static void dfs2(ArrayList<ArrayList<Integer>> list, boolean visited[], int start)
//    {
//        visited[start]=true;
//        ArrayList<Integer> temp = list.get(start);
//        for(int i=0; i<temp.size(); i++)
//        {
//            int num=temp.get(i);
//            if(visited[num]==false)
//            {
//                dfs2(list,visited,num);
//            }
//        }
//    }
//    
//    public int kosaraju( int n, ArrayList<ArrayList<Integer>> list)
//    {
//      stack = new Stack<Integer>();
//      boolean visited[]= new boolean[n];
//      for(int i=0; i<n; i++)
//      {
//          if(visited[i]==false)
//          {
//              dfs(list,visited,i,stack);
//          }
//      }
//      
//     ArrayList<ArrayList<Integer>> revlist = new ArrayList<ArrayList<Integer>>();
//     
//     for(int i=0; i<n; i++)
//     {
//         revlist.add(new ArrayList<Integer>());
//     }
//     reverse(revlist, list);
//     
//     Arrays.fill(visited,false);
//     int cnt=0;
//     while(!stack.isEmpty())
//     {
//         int start= stack.pop();
//         if(visited[start]==false)
//         {
//             cnt++;
//             dfs2(revlist, visited, start);
//         }
//     }
//     return cnt;
//    }
//}
