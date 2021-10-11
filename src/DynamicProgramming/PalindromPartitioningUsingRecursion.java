package DynamicProgramming;

public class PalindromPartitioningUsingRecursion {
//	//		Time complexity  : There could be O(n^2) unique sub-problems to any partitioning given problem and for every such sub-problem there could be O(n) splits possible.
//  So it is O(n^3).
//	Space complexity : O(n);
	public static int palPart(String s, int i, int j) {
		if (isPalindrome(s, i, j)) {
			return 0;
		}
		int res = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			res = Math.min(res, 1 + palPart(s, i, k) + palPart(s, k + 1, j));
		}
		return res;
	}

	public static boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l++) != s.charAt(r--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "geek";
		System.out.println("Minimum Partition Required: " + palPart(str, 0, str.length() - 1));
	}

}
