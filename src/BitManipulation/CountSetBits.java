package BitManipulation;

public class CountSetBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println(countSetBits1(n));
		System.out.println(countSetBits2(n));
		System.out.println(countSetBits3(n));
	}

	public static int countSetBits1(int n) {
		int count = 0;
		while (n > 0) {
			if (n % 2 != 0) {/*-> n&1 != 0 or instead of whole if block -> count += (n&1)*/
				count++;
			}
			n = n / 2;/*-> n>>1 */
		}
		return count;
	}

//   Brian Kerningam's Algo, Time Complexity: O(no. of set bits), SC: O(1)
	public static int countSetBits2(int n) {
		/*
		 * n = 40 = ......101000 n-1->reducing by 1-> makes right most / last set bit 0
		 * and all after that 1 n-1 = 39-> 100111 n & n-1 = 100000 = 32
		 */
		int count = 0;
		while (n > 0) {
			n = (n & n - 1);
			count++;
		}
		return count;
	}

	public static int countSetBits3(int n) {
		int count = 0;
		/*
		 * divide 32 into 4 equal parts -> 8 8 8 8 8 bits ->0 to 2^7 -1 = 256
		 * combinations
		 */
		int table[] = new int[256];
		table[0] = 0;
		for (int i = 1; i < table.length; i++) {
			table[i] = (i & 1) + table[i / 2]; // same logic as countSetBits1
		}
//		0xff - hexadecimal represenation of all last 8 bits in 32 bits as 1
		count += table[n & 0xff];
		n = n >> 8; // fetching next 8 bits;
		count += table[n & 0xff];
		n = n >> 8; // fetching next 8 bits;
		count += table[n & 0xff];
		n = n >> 8; // fetching next 8 bits;
		count += table[n & 0xff];
		return count;
	}
}

/*
 * You are given a number N. Find the total count of set bits for all numbers
 * from 1 to N(both inclusive).
 * 
 * Example 1:
 * 
 * Input: N = 4 Output: 5 Explanation: For numbers from 1 to 4. For 1: 0 0 1 = 1
 * set bits For 2: 0 1 0 = 1 set bits For 3: 0 1 1 = 2 set bits For 4: 1 0 0 = 1
 * set bits Therefore, the total set bits is 5.
 */
class Solution {

	// Function to return sum of count of set bits in the integers from 1 to n.
	public static int countSetBits(int n) {

		// Your code here
		return solve(n);

	}

	public static int solve(int n) {
		if (n <= 0) {
			return 0;
		}
		// to find greates pow of 2 less than or equal to n
		int x = 1;
		while ((1 << x) <= n) {
			x++;
		}
		x--;
		// no of set bits from 0 to 2^x(exclusive)
		int sToPow = (x * (1 << (x - 1)));
		// total no. of most significant set bits from 2^x to n(inclusive)
		int powToE = (n - (1 << x) + 1);
		// remaing set bits in 2^x to n
		int remain = solve((n - (1 << x)));
		return (sToPow + powToE + remain);
	}
}