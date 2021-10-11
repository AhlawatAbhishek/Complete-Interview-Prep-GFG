package String;

public class NaiveDistinctPatternSearching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "ABCEABEFABCD";
		String pat = "ABCD";
		distinctPatternSearching(txt, pat);
	}

//Time Complexity theta(N) && Space Complexity O(1);
	public static void distinctPatternSearching(String txt, String pat) {
		int n = txt.length();
		int m = pat.length();
		for (int i = 0; i <= n - m;) {
			int j;
			for (j = 0; j < m; j++) {
				if (pat.charAt(j) != txt.charAt(i + j)) {
					break;
				}
			}
			if (j == m) {
				System.out.print(i + " ");
			}
			if (j == 0) {
				i++;
			} else {
				i = i + j;
			}
		}
	}
}
