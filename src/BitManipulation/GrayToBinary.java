package BitManipulation;

public class GrayToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given N in Gray code equivalent. Find its binary equivalent. Note: We need to
	 * find the binary equivalent of the given gray code and return the decimal
	 * equivalent of the binary representation.
	 * 
	 * Example 1:
	 * 
	 * Input: N = 4 Output: 7 Explanation: 4 is represented as gray 100 and its
	 * binary equivalent is 111 whose decimal equivalent is 7.
	 */
	public static int grayToBinary(int n) {

		// Your code here
		int num = n;
		while (n > 0) {
			n = n >> 1;
			num = num ^ n;
		}
		return num;
	}

}
