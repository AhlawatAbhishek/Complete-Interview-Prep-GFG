package BackTracking;

import java.util.List;

/*
 * Given an undirected graph and an integer M.
 *  The task is to determine if the graph can be colored with
 *   at most M colors such that no two adjacent vertices of the
 *    graph are colored with the same color. Here coloring of a
 *     graph means the assignment of colors to all vertices.
 *      Print 1 if it is possible to colour vertices and 0 otherwise.

Example 1:

Input:
N = 4
M = 3
E = 5
Edges[] = {(1,2),(2,3),(3,4),(4,1),(1,3)}
Output: 1
Explanation: It is possible to colour the
given graph using 3 colours.
 * */
public class MColoringProblem {
	// C - total Colors, i - source Vertex, color - empty arr, g - Graph
	public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
		// all vertices have been assigned colour
		if (i == G.length)
			return solved(G, color);

		for (int c = 1; c <= C; c++) {
			// check for if this colour can be given to a particular node
			if (legal(G, color, i, c)) {
				// assigning colour to the node
				color[i] = c;

				// now recursing and checking if other nodes can be assigned
				// other colours
				if (graphColoring(G, color, i + 1, C))
					return true; // return true if the current allocation was
									// successful

				// if not true, backtrack, and remove the colour for that node
				color[i] = 0;
			}
		}

		// if all possibilities are false, and no colour can be assigned, return
		// false
		return false;
	}

	public static boolean solved(List<Integer>[] G, int[] color) {
		for (int i = 0; i < G.length; i++) {
			for (int nei : G[i]) {
				if (color[i] == 0 || color[i] == color[nei])
					return false;
			}
		}
		return true;
	}

	public static boolean legal(List<Integer>[] G, int[] color, int i, int c) {
		// checking if the connected nodes to v have same colour as c
		for (int nei : G[i]) {
			if (color[nei] == c)
				return false;
		}
		return true; // return true if no connected node has same colour
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
