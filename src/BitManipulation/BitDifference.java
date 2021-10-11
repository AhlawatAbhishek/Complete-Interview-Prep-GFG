package BitManipulation;

public class BitDifference {
	/*
	 * You are given two numbers A and B. The task is to count the number of bits
	 * needed to be flipped to convert A to B.
	 * 
	 * Example 1:
	 * 
	 * Input: A = 10, B = 20 Output: 4 Explanation: A = 01010 B = 10100 As we can
	 * see, the bits of A that need to be flipped are 01010. If we flip these bits,
	 * we get 10100, which is B.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countBitsFlip1(20, 25));
		System.out.println(countBitsFlip2(20, 25));
	}

	public static int countBitsFlip1(int a, int b) {

		// Your code here
		int XOR = a ^ b;
		int count = 0;
		while (XOR > 0) {
			count++;
			XOR = XOR & (XOR - 1);
		}
		return count;
	}

	public static int countBitsFlip2(int a, int b) {
		int c = 0;
		while (a > 0 || b > 0) {
			int a_bit = a & 1; // getting LSB of a
			int b_bit = b & 1; // getting LSB of b

			if (a_bit != b_bit) // checking if both LSB are Diff then count++
				c++;

			a >>= 1; // right shifting the bits of a
			b >>= 1; // right shifting the bits of b
		}
		return c;
	}

}
