package String;

public class CheckIfSubsequence {
//	Time complexity : O(N) and space complexity: O(1) 
	public static boolean isSubSeq(String s1, String s2, int len1, int len2) {
		int j = 0;
		if (len1 < len2) {
			return false;
		}
		for (int i = 0; i < s1.length() && j < len2; i++) {
			if (s1.charAt(i) == s2.charAt(j)) {
				j++;
			}
		}
		if (j == len2) {
			return true;
		}
		return false;
	}

//	Time complexity : O(N+M) and space complexity: O(N+M) 
	public static boolean isSubSeq2(String s1, String s2, int len1, int len2) {
		if (len1 == 0) {
			return false;
		}
		if (len2 == 0) {
			return true;
		}
		if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
			return isSubSeq2(s1, s2, len1 - 1, len2 - 1);
		} else {
			return isSubSeq2(s1, s2, len1 - 1, len2 - 1);
		}

	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n, m;
//		n = sc.nextInt();
//		m = sc.nextInt();

		String s1, s2;
		s1 = "ABCDEF";
		s2 = "ABD";

		System.out.println(isSubSeq2(s1, s2, 6, 3));
	}

}
