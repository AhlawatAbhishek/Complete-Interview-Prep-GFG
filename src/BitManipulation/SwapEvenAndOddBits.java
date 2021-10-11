package BitManipulation;

public class SwapEvenAndOddBits {
	public static int swapBits(int n) {
		/*
		 * Given an unsigned integer N. The task is to swap all odd bits with even bits.
		 * For example, if the given number is 23 (00010111), it should be converted to
		 * 43(00101011). Here, every even position bit is swapped with adjacent bit on
		 * the right side(even position bits are highlighted in the binary
		 * representation of 23), and every odd position bit is swapped with an adjacent
		 * on the left side.
		 * 
		 * Example 1:
		 * 
		 * Input: N = 23 Output: 43 Explanation: Binary representation of the given
		 * number is 00010111 after swapping 00101011 = 43 in decimal.
		 */
		// Your code
		int eve = (n & 0xAAAAAAAA);// 0xAAAAAAAA -- all even(pos) digits as one and odd position as 0
		int odd = (n & 0x55555555);// 0x55555555 -- all even pos digits as 0 and odd(position) as 1
		eve = eve >> 1;
		odd = odd << 1;
		return eve | odd;// or to swap digits

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(swapBits(23));
	}

}
