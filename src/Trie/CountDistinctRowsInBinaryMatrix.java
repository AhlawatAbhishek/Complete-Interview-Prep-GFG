package Trie;

public class CountDistinctRowsInBinaryMatrix {
	static final int M = 4, N = 3;
	static int mat[][] = { { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };

	static class TrieNode {
		TrieNode children[] = new TrieNode[2];
	}

	public static boolean isDistinct(TrieNode root, int row) {
		TrieNode curr = root;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			int indx = mat[row][i];
			if (curr.children[indx] == null) {
				curr.children[indx] = new TrieNode();
				flag = true;
			}
			curr = curr.children[indx];
		}
		return flag;
	}

//Time complexity: O(M*N) and space complexity or auxiliary space : O(M*N)
	public static int countDis() {
		int res = 0;
		TrieNode root = new TrieNode();
		for (int i = 0; i < M; i++) {
			if (isDistinct(root, i)) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(countDis());

	}

}
