package DynamicProgramming;

public class MaxSumSubarrayByRemovingAtMostOneElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxSumSubarray(int A[], int n) {
		// add code here.
		int res = A[0];
		// sum If We Add Or Just Take Current Element As CurrentSum
		int s = A[0];
		// sum If We add current element or take previous sum ignoring current element;
		int t = A[0];
		for (int i = 1; i < A.length; i++) {
			t = Math.max(t + A[i], s);
			s = Math.max(s + A[i], A[i]);
			res = Math.max(Math.max(s, t), res);
		}
		return res;
	}
	/*
	 * Input: n = 5 A[] = {1,2,3,-4,5} Output: 11 Explanation: We can get maximum
	 * sum subarray by skipping -4.
	 */

}
