package SegmenTrees;

//also called Fenwick Tree 
public class BinaryIndexedTree {
	public static final int size = 1000;
	int BI[] = new int[size];

	// Time complexity : O(log n) and auxiliary space O(1)
	public void updateBITree(int arr[], int i, int val, int n) {
		int diff = val - arr[i];
		arr[i] = val;
		i = i + 1;
		while (i <= n) {
			BI[i] += diff;
			//this is for finding the children
			i += i & (-i);
		}
	}
	public void updateBITreeBuild(int arr[], int i, int val){
		i = i + 1;
		while (i <= arr.length) {
			BI[i] += val;
			//this is for finding the children
			i += i & (-i);
		}
	}
//Time complexity : O(n*logn) and auxiliary space O(n)
	public void constructBITree(int arr[], int n) {
		for (int i = 1; i <= n; i++) {
			BI[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			updateBITreeBuild(arr, i, arr[i]);
		}
	}

	// Time complexity : O(log n) and auxiliary space O(1)
	public int getSum(int i) {
		i++;
		int sum = 0;
		while (i > 0) {
			sum += BI[i];
			//this is for finding the parent
			i -= i & (-i);
		}
		return sum;
	}

	public static void main(String[] args) {
		int freq[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int n = freq.length;
		BinaryIndexedTree tree = new BinaryIndexedTree();

		tree.constructBITree(freq, n);

		System.out.println("Sum of elements in arr[0..5]" + " is " + tree.getSum(5));
	}

}
