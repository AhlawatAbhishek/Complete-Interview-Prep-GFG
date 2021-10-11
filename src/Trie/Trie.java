package Trie;

public class Trie {
	static final int Alphabet_Size = 26;

	static class TrieNode {
		TrieNode children[] = null;
		boolean isEnd;

		TrieNode() {
			children = new TrieNode[Alphabet_Size];
		}
	}

	static TrieNode root;

//Time complexity : 0(N) and space complexity or auxiliary space: O(1)
	public static void insert(String key) {
		int len = key.length();
		TrieNode curr = root;
		for (int i = 0; i < len; i++) {
			int index = key.charAt(i) - 'a';
			if (curr.children[index] == null) {
				curr.children[index] = new TrieNode();
			}
			curr = curr.children[index];
		}
		curr.isEnd = true;
	}

	// Time complexity : O(N) and space complexity or auxiliary space: O(1)
	public static boolean search(String key) {
		int len = key.length();
		TrieNode curr = root;
		for (int i = 0; i < len; i++) {
			int index = key.charAt(i) - 'a';
			if (curr.children[index] == null) {
				return false;
			}
			curr = curr.children[index];
		}
		return (curr != null && curr.isEnd);
	}

//Time complexity : O(n) and space complexity: O(n) for recursion stack
	public static TrieNode remove(TrieNode root, String key, int index) {
		if (root == null) {
			return null;
		}
		if (index == key.length()) {
			if (root.isEnd)
				root.isEnd = false;
			if (isEmpty(root)) {
				root = null;
			}
			return root;
		}
		int ind = key.charAt(index) - 'a';
		root.children[ind] = remove(root.children[ind], key, index + 1);
		if (!root.isEnd && isEmpty(root)) {
			root = null;
		}
		return root;
	}

	public static boolean isEmpty(TrieNode root) {
		for (int i = 0; i < Alphabet_Size; i++) {
			if (root.children[i] != null) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String keys[] = { "an", "and", "ant", "bad", "bat", "zoo" };

		String output[] = { "NO", "YES" };

		root = new TrieNode();

		int i;
		for (i = 0; i < keys.length; i++)
			insert(keys[i]);

		root = remove(root, "zoo", 0);

		if (search("zoo") == true)
			System.out.println("zoo --- " + output[1]);
		else
			System.out.println("zoo --- " + output[0]);
//		String keys[] = { "bad", "bat", "geeks", "geeks", "cat", "cut" };
//
//		String output[] = { "NO", "YES" };
//
//		root = new TrieNode();
//
//		int i;
//		for (i = 0; i < keys.length; i++)
//			insert(keys[i]);
//
//		if (search("bad") == true)
//			System.out.println("bad --- " + output[1]);
//		else
//			System.out.println("bad --- " + output[0]);
//
//		if (search("geeks") == true)
//			System.out.println("geeks --- " + output[1]);
//		else
//			System.out.println("geeks --- " + output[0]);
//
//		if (search("ca") == true)
//			System.out.println("ca --- " + output[1]);
//		else
//			System.out.println("ca --- " + output[0]);
	}

}
