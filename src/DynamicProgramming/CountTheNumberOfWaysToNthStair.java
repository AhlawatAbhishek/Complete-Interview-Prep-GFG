package DynamicProgramming;

/*There are N stairs, and a person standing at the bottom wants to reach the top. 
 * The person can climb either 1 stair or 2 stairs at a time.
 *  Count the number of ways, the person can reach the top (order does not matter).
Note: Order does not matter means for n=4 {1 2 1},{2 1 1},{1 1 2} are considered
 same.

Example 1:

Input:
N = 4
Output: 3
Explanation: You can reach 4th stair in
3 ways.
3 possible ways are:
1, 1, 1
1, 1, 2
2, 2*/
public class CountTheNumberOfWaysToNthStair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// function to find number of ways

	Long countWays(int m) {

		// your code here
		//
		int no = m;
		long arr[] = new long[no + 1];
		int i;

		arr[0] = 1;
		for (i = 1; i <= no; i++)
			arr[i] = arr[i] + arr[i - 1];

		for (i = 2; i <= no; i++)
			arr[i] = arr[i] + arr[i - 2];

		return arr[no];

	}

}
