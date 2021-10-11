package DynamicProgramming;

import java.util.Arrays;

public class SubsetSumProblemUsingTopDownDPOrMemoization {
	int memo[];

	public boolean findPartition(int[] a, int n) {
		if (n == 1) {
			return false;
		}

		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		if (sum % 2 != 0) {
			return false;
		}
		memo = new int[sum];
		Arrays.fill(memo, -1);
		return isPossible(a, 0, 0, sum / 2);
	}

	public boolean isPossible(int a[], int idx, int len, int sum) {
		if (sum < 0) {
			return false;
		}
		if (len == a.length - 1 || idx == a.length) {
			if (sum == 0) {
				return true;
			} else {

				return false;
			}
		}
		if (memo[sum] != -1) {
			return memo[sum] == 1 ? true : false;
		}

		if (isPossible(a, idx + 1, len + 1, sum - a[idx]) || isPossible(a, idx + 1, len, sum)) {
			memo[sum] = 1;
		}

		boolean res = false;
		if (memo[sum] == 1) {
			res = true;
		}
		return res;
	}
	/*
	 * Given a set of numbers, check whether it can be partitioned into two subsets
	 * such that the sum of elements in both subsets is same or not.
	 * 
	 * Example 1:
	 * 
	 * Input: N = 4 arr[] = {1,5,11,5} Output: YES Explanation: There exists two
	 * subsets such that {1, 5, 5} and {11}.
	 */
}
