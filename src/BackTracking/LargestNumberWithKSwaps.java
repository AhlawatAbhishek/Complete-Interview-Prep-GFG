package BackTracking;

class Str {
	String max = "";
}
/*
 * Given a number K and string str of digits denoting a positive integer, build
 * the largest number possible by performing swap operations on the digits of
 * str at most K times.
 * 
 * 
 * Example 1:
 * 
 * Input: K = 4 str = "1234567" Output: 7654321 Explanation: Three swaps can
 * make the input 1234567 to 7654321, swapping 1 with 7, 2 with 6 and finally 3
 * with 5
 */

public class LargestNumberWithKSwaps {
	public static String findMaximumNum(String str, int k) {
		// code here.
		char ch[] = str.toCharArray();
		Str s = new Str();
		s.max = str;
		findMax(ch, k, s);
		return s.max;
	}

	public static void findMax(char[] ch, int k, Str str) {
		if (k == 0) {
			return;
		}
		for (int i = 0; i < ch.length; i++) {
			for (int j = i + 1; j < ch.length; j++) {
				if (ch[i] - '0' < ch[j] - '0') {
					swap(ch, i, j);
					String s = new String(ch);
					if (str.max.compareTo(s) < 0) {
						str.max = s;
					}
					findMax(ch, k - 1, str);
					swap(ch, i, j);
				}
			}
		}
	}

	public static void swap(char arr[], int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
