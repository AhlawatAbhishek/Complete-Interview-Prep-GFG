package DynamicProgramming;

public class MatrixChainMulitplicationUsingRecursion {
	static int MatrixChainMultiplication(int p[], int i, int j) {
//		Time complexity  : There could be O(n^2) unique sub-problems to any MCM given problem and for every such sub-problem there could be O(n) splits possible.
//      So it is O(n^3).
//		Space complexity : O(n);
		if (i + 1 == j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = i + 1; k < j; k++) {
			int count = MatrixChainMultiplication(p, i, k) + MatrixChainMultiplication(p, k, j) + p[i] * p[j] * p[k];
			if (count < min) {
				min = count;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 40, 20, 30, 10, 30 };
		int n = arr.length;
		System.out.println("Minimum number of multiplications is " + MatrixChainMultiplication(arr, 0, n - 1));
	}

}
