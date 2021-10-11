package DisjointSet;

public class FindByPathCompressionAndUnionByRank {
	static int parent[] = null;
	static int ranks[] = null;

	public static void initialize() {
		for (int indx = 0; indx < parent.length; indx++) {
			parent[indx] = indx;
			ranks[indx] = 0;
		}
	}

	// Time complexity: O(Alpha(n)), Alpha(n) <= 4, therefore O(1) and auxiliary
	// space: O(1) for recursion stack
	public static void union(int x, int y) {
		int xRep = find(x);
		int yRep = find(y);
		if (xRep == yRep)
			return;
		if (ranks[xRep] < ranks[yRep])
			parent[xRep] = yRep;
		else if (ranks[yRep] < ranks[xRep])
			parent[yRep] = xRep;
		else {
			parent[yRep] = xRep;
			ranks[xRep]++;
		}
	}

	// Time complexity: O(LogN) and auxiliary space: O(1) for recursion stack
	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static void main(String[] args) {
		int n = 5;

		parent = new int[5];
		ranks = new int[5];

		initialize();

		union(3, 4);
		union(2, 3);
		union(1, 2);
		union(0, 1);

		System.out.println(parent[3]);
		System.out.println(ranks[3]);
	}

}
