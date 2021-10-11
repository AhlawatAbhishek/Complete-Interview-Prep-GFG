package String;

public class KMPAlgoFillingLpsNaive {
//	Time complexity : O(N^ 3) and space complexity : O(1)
	static int longPropPreSuff(String str, int n) {
		for (int len = n - 1; len > 0; len--) {
			boolean flag = true;
			for (int i = 0; i < len; i++)
				if (str.charAt(i) != str.charAt(n - len + i))
					flag = false;

			if (flag == true)
				return len;
		}
		return 0;
	}

	static void fillLPS(String str, int lps[]) {
		for (int i = 0; i < str.length(); i++) {
			lps[i] = longPropPreSuff(str, i + 1);
		}
	}

	public static void main(String args[]) {
		String txt = "abacabad";
		int[] lps = new int[txt.length()];
		fillLPS(txt, lps);
		for (int i = 0; i < txt.length(); i++) {
			System.out.print(lps[i] + " ");
		}
	}
}
