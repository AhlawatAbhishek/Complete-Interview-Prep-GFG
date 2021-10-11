package String;

public class NaivePatternSearhing {

	public static void main(String[] args) {
		String txt = "ABCABCD";
		String pat = "ABCD";
		patternSearching2(txt, pat);
	}

//Time Complexity = O((n-m+1)*m) and Space complexity(Auxillary space)
	public static void patternSearching(String txt, String pat) {
		int m = pat.length();
		int n = txt.length();
		for (int i = 0; i <= (n - m); i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (pat.charAt(j) != txt.charAt(i + j))
					break;
			}
			if (j == m)
				System.out.print(i + " ");
		}
	}

	public static void patternSearching2(String txt, String pat) {
		int m = pat.length();
		int n = txt.length();
		int j = 0, ans = -1;
		for (int i = 0; i < n; i++) {

			if (txt.charAt(i) == pat.charAt(j)) {
				if (j == 0) {
					ans = i;
				}

				j++;
			} else {
				ans = -1;
				j = 0;
				if (txt.charAt(i) == pat.charAt(j)) {
					if (j == 0) {
						ans = i;
					}
					j++;
				}

			}
			if (j == m) {
				System.out.print(ans + " ");
				j = 0;
				ans = -1;
			}

		}
	}
}
