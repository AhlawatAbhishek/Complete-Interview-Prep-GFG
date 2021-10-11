package Tree;

class Distance {
	int value;

	Distance(int v) {
		this.value = v;
	}
}

public class BurnABinaryTreeFromALeaf {
	int res = Integer.MIN_VALUE;

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.left.left.left = new Node(60);
		root.left.left.left.left = new Node(70);
		Distance dist = new Distance(-1);
		int leaf = 50;
		BurnABinaryTreeFromALeaf bObj = new BurnABinaryTreeFromALeaf();
		bObj.burnFromLeaf(root, dist, leaf);
		System.out.println("Time taken to burn the whole tree : " + bObj.res);
	}

//Time complexity : O(N) and space complexity or auxiliary space: O(h/ log(n))
	public int burnFromLeaf(Node root, Distance d, int leaf) {
		if (root == null) {
			return 0;
		}
		if (root.data == leaf) {
			d.value = 0;
			return 1;
		}
		Distance ld = new Distance(-1), rd = new Distance(-1);
		int lh = burnFromLeaf(root.left, ld, leaf);
		int rh = burnFromLeaf(root.right, rd, leaf);
		if (ld.value != -1) {
			d.value = ld.value + 1;
			res = Math.max(res, d.value + rh);
		} else if (rd.value != -1) {
			d.value = rd.value + 1;
			res = Math.max(res, d.value + lh);
		}

		return Math.max(lh, rh) + 1;
	}
}
