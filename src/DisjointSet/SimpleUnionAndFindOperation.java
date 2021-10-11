package DisjointSet;

public class SimpleUnionAndFindOperation {
	static int parent[];

	private static void initialize() {
		for (int indx = 0; indx < parent.length; indx++) {
			parent[indx] = indx;
		}
	}

//Time complexity: O(N) and auxiliary space: O(N) for recursion stack
	private static int find(int x) {
		if (parent[x] == x) {
			return parent[x];
		}
		return find(parent[x]);
	}

//Time complexity: O(N) and auxiliary space: O(N) for recursion stack 
	public static void union(int x, int y) {
		int x_rep = find(x);
		int y_rep = find(y);
		if (x_rep == y_rep) {
			return;
		}
		parent[y_rep] = x_rep;
	}

	public static void main(String[] args) {
		int n = 5;

		parent = new int[5];

		initialize();

		union(0, 2);
		union(0, 4);

		System.out.println(find(4));
		System.out.println(find(3));
	}

}
