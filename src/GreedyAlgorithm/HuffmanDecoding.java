package GreedyAlgorithm;

class MinHeapNode {
	char data;
	int freq;
	MinHeapNode left, right, top;

	MinHeapNode(char c, int freq) {
		left = right = null;
		this.data = c;
		this.freq = freq;
	}
}

public class HuffmanDecoding {
	static String decodeHuffmanData(MinHeapNode root, String binaryString) {

		String answer = "";
		MinHeapNode curr = root;
		;
		int i = 0;
		while (i < binaryString.length()) {

			if (binaryString.charAt(i) == '1') {
				curr = curr.right;
			} else if (binaryString.charAt(i) == '0') {
				curr = curr.left;
			}
			if (curr != null && curr.left == null && curr.right == null) {
				answer += curr.data;
				curr = root;
			}
			i++;
		}
		return answer;
		// add your code here
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "geeksforgeeks";
//		in place of null the minheap node would be intialized in the question
		System.out.println(decodeHuffmanData(null, s));
	}

}
