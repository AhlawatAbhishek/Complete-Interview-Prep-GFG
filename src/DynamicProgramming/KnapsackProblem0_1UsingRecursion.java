package DynamicProgramming;

public class KnapsackProblem0_1UsingRecursion {
//	Time Complexity : O(2^n) and space complexity: O(n) as recursion stack cannot have more than n
//	recursive calls at a time;
	static int maximizeValue(int v[], int[] w, int W, int value, int index) {
		if (index < 0 || W == 0) {
			return value;
		}
		int res = 0;
		if (w[index] <= W) {
			res = maximizeValue(v, w, W - w[index], value + v[index], index - 1);
		}
		res = Math.max(res, maximizeValue(v, w, W, value, index - 1));
		return res;

	}

	public static void main(String[] args) {
		int v[] = { 60, 100, 120 }, w[] = { 10, 20, 30 }, W = 50;

		System.out.println(maximizeValue(v, w, W, 0, v.length - 1));

	}

}
