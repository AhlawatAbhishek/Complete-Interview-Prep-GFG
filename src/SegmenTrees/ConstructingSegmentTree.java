package SegmenTrees;

public class ConstructingSegmentTree {
//	Time complexity : 0(N) and auxiliary space: O(h) - height of segment tree
	public static int CST(int si, int ei, int rootIndx, int arr[], int tree[]) {
		if (si == ei) {
			return tree[rootIndx] = arr[si];
		} else if (si < ei) {
			int mid = si + (ei - si) / 2;
			tree[rootIndx] = CST(si, mid, 2 * rootIndx + 1, arr, tree) + CST(mid + 1, ei, 2 * rootIndx + 2, arr, tree);
			return tree[rootIndx];
		} else {
			return -1;
		}
	}

//Time complexity: O(h), h=logn  and auxiliary space : O(h)
	public static int getSumRec(int qs, int qe, int si, int ei, int i, int tree[]) {
		if (ei < qs || si > qe) {
			return 0;
		}
		if (qs <= si && qe >= ei) {
			return tree[i];
		}
		int mid = si + (ei - si) / 2;
		return getSumRec(qs, qe, si, mid, 2 * i + 1, tree) + getSumRec(qs, qe, mid + 1, ei, 2 * i + 2, tree);
	}

	// Time complexity: O(h), h=logn and auxiliary space : O(h)
	public static void updateRec(int si, int ei, int i, int rootIndx, int diffVal, int tree[]) {
		if (si > i || ei < i) {
			return;
		}
		tree[rootIndx] += diffVal;
		if (si < ei) {
			int mid = si + (ei - si) / 2;
			updateRec(si, mid, i, 2 * rootIndx + 1, diffVal, tree);
			updateRec(mid + 1, ei, i, 2 * rootIndx + 2, diffVal, tree);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40 }, n = 4;

		int tree[] = new int[4 * n];

		CST(0, n - 1, 0, arr, tree);
		System.out.println(tree[1]);
		updateRec(0, 3, 1, 0, 5, tree);
		System.out.println(tree[1]);
		System.out.println(getSumRec(0, 2, 0, 3, 0, tree));
	}

}
