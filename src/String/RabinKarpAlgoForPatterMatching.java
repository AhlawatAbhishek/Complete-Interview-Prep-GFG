package String;

public class RabinKarpAlgoForPatterMatching {
	public static final int d = 256;
	public static final int q = 101;

//Time complexity: O((N-M+1)*M) and space complexity or auxiliary space : O(1)
	public static void RBSearch(String pat, String txt, int pLen, int tLen) {
		int h = 1;
		int p = 0, t = 0;
//		Computing d ^ pLen-1;
		for (int i = 1; i <= pLen - 1; i++) {
			h = (h * d) % q;
		}
//		computing p and t 
		for (int i = 0; i < pLen; i++) {
			p = (p * d + pat.charAt(i)) % q;
			t = (t * d + txt.charAt(i)) % q;
		}

		for (int i = 0; i <= tLen - pLen; i++) {
			if (p == t) {
				boolean flag = true;
//				comparing word by word;
				for (int j = 0; j < pLen; j++) {
					if (txt.charAt(i + j) != pat.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.print(i + ", ");
				}
			}
			if (i < tLen - pLen) {
				t = ((t - (txt.charAt(i) * h)) * d + txt.charAt(i + pLen)) % q;
				if (t < 0) {
					t = t + q;
				}
			}
		}
	}

	public static void main(String[] args) {
		String txt = "GEEKS FOR GEEKS";
		String pat = "GEEK";
		System.out.print("All index numbers where pattern found: ");
		RBSearch(pat, txt, 4, 15);
	}

}
