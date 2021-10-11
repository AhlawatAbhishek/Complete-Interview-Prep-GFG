package BitManipulation;

public class IsNumberSparseOrNot {
	/*
	 * Given a number N. The task is to check whether it is sparse or not. A number
	 * is said to be a sparse number if no two or more consecutive bits are set in
	 * the binary representation.
	 * 
	 * Example 1:
	 * 
	 * Input: N = 2 Output: true Explanation: Binary Representation of 2 is 10,
	 * which is not having consecutive set bits. So, it is sparse number.
	 */
	public static boolean isSparse(int n) {
		boolean isPrevSet = false;
		while (n > 0) {
			if (n % 2 != 0) {
				if (isPrevSet) {
					return false;
				}
				isPrevSet = true;
			} else {
				isPrevSet = false;
			}
			n = n / 2;
		}

		return true;
	}

	public static boolean isSparse2(int n) {

		// Your code here
		boolean isPrevSet = false;
		while (n > 0) {
			if ((n & 1) != 0) {
				if (isPrevSet) {
					return false;
				}
				isPrevSet = true;
			} else {
				isPrevSet = false;
			}
			n = n >> 1;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isSparse(2));
		System.out.println(isSparse2(2));
		System.out.println(isSparse(3));
		System.out.println(isSparse2(3));
	}

}
