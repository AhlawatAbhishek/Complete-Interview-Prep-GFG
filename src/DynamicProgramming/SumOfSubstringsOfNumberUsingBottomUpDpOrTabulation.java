package DynamicProgramming;

public class SumOfSubstringsOfNumberUsingBottomUpDpOrTabulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static long sumSubstrings(String num) {
		// Your code here
		int n = num.length();

		// allocate memory equal to length of string
		long sumofdigit[] = new long[n];

		// initialize first value with first digit
		sumofdigit[0] = num.charAt(0) - '0';
		long res = sumofdigit[0];

		// loop over all digits of string
		for (int i = 1; i < n; i++) {
			long numi = num.charAt(i) - '0';

			// update each sumofdigit from previous value
			sumofdigit[i] = ((i + 1) % 1000000007) * (numi % 1000000007)
					+ (10 % 1000000007) * (sumofdigit[i - 1] % 1000000007);

			// add current value to the result
			res = (res + sumofdigit[i]) % 1000000007;
		}

		return res % 1000000007;
	}

}
/*
 * Given an integer S represented as a string, the task is to get the sum of all
 * possible sub-strings of this string. As the answer will be large, print it
 * modulo 10^9+7.
 * 
 * Example 1:
 * 
 * Input: S = 1234 Output: 1670 Explanation: Sum = 1 + 2 + 3 + 4 + 12 + 23 + 34
 * + 123 + 234 + 1234 = 1670
 * 
 * For above example, sumofdigit[3] = 4 + 34 + 234 + 1234 = 4 + 30 + 4 + 230 + 4
 * * + 1230 + 4 = 4*4 + 10*(3 + 23 +123) = 4*4 + 10*(sumofdigit[2]) In general,
 * sumofdigit[i] = (i+1)*num[i] + 10*sumofdigit[i-1]
 */
