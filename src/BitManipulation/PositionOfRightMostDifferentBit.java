package BitManipulation;

public class PositionOfRightMostDifferentBit {
	/*
	 * Given two numbers M and N. The task is to find the position of the rightmost
	 * different bit in the binary representation of numbers.
	 * 
	 * Example 1:
	 * 
	 * Input: M = 11, N = 9 Output: 2 Explanation: Binary representation of the
	 * given numbers are: 1011 and 1001, 2nd bit from right is different.
	 */
	public static int posOfRightMostDiffBit(int m, int n) {

		// Your code here
		int num = m ^ n;
		return findFirstSetBit(num);
	}

	public static int findFirstSetBit(int num) {
		int a = num ^ (num - 1);
		int res = (int) (Math.log(a + 1) / Math.log(2));
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(posOfRightMostDiffBit(11, 9));
	}

}
