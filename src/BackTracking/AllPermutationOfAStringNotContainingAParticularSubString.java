package BackTracking;

public class AllPermutationOfAStringNotContainingAParticularSubString {
//          N! = number of permutations and N is for number of checks for valid String    
	// time complexity: O(n! * n) and space complexity O(n)
	public static void permute(String str, int l, int r) {
		if (l == r) {
			if (!str.contains("AB")) {
				System.out.print(str + " ");
			}
			return;
		}
		for (int i = l; i < str.length(); i++) {
			str = swap(str, i, l);
			permute(str, l + 1, r);
			str = swap(str, i, l);
		}
	}

	// time complexity: O(n! * n) and space complexity O(n)// time complexity
//	is somewhat less than O(n! * n) as n! part would be less;
	public static void efficientPermute(String str, int l, int r) {
		if (l == r) {
			System.out.print(str + " ");
		}
		for (int i = l; i < str.length(); i++) {
			if (isSafe(str, i, l, r)) {
				str = swap(str, i, l);
				permute(str, l + 1, r);
				str = swap(str, i, l);
			}
		}
	}

	public static boolean isSafe(String str, int i, int l, int r) {
		if (l != 0 && str.charAt(i) == 'B' && str.charAt(l - 1) == 'A') {
			return false;
		}
		if (r == 1 + 1 && str.charAt(i) == 'A' && str.charAt(l) == 'B') {
			return false;
		}
		return true;
	}

	public static String swap(String str, int i, int j) {
		char st[] = str.toCharArray();
		char temp = st[i];
		st[i] = st[j];
		st[j] = temp;
		return new String(st);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABC";

		permute(str, 0, str.length() - 1);
		System.out.println();
		efficientPermute(str, 0, str.length() - 1);
	}

}
