package Searching;

public class SquareRoot {
//	Time complexity: O(N^1/2) and auxiliary space: O(1)
	public static int sqRootFloor(int val) {
		int i = 0;
		while (i * i <= val) {
			i++;
		}
		return i - 1;
	}

//	Time complexity: O(LogN) and auxiliary space: O(1)
	public static int sqRootFloor1(int val) {
		int lo = 0, hi = val, ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (mid * mid > val) {
				hi = mid - 1;
			} else if (mid * mid == val) {
				return mid;
			} else {
				ans = mid;
				lo = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(sqRootFloor(15));
		System.out.println(sqRootFloor1(15));

	}

}
