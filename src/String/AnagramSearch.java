package String;

public class AnagramSearch {
	final static int CHAR = 256;

//Time complexity : O((n-m+1)*m) and space complexity or auxiliary space : O(CHAR);
	public static boolean isPresent(String txt, String pat) {
		int txtLen = txt.length(); // m
		int patLen = pat.length();// n
		for (int i = 0; i <= txtLen - patLen; i++) {
			if (isAnagram(txt, pat, i)) {
				return true;
			}
		}
		return false;
	}

////Time complexity : O(n * CHAR) and space complexity or auxiliary space : O(CHAR);
	public static boolean isPresent2(String txt, String pat) {
		int CT[] = new int[CHAR];
		int CP[] = new int[CHAR];
		for (int i = 0; i < pat.length(); i++) {
			CT[txt.charAt(i)]++;
			CP[pat.charAt(i)]++;
		}
		for (int i = pat.length(); i < txt.length(); i++) {
			if (areSame(CT, CP)) {
				return true;
			}
			CT[txt.charAt(i)]++;
			CT[txt.charAt(i - pat.length())]--;
		}
		return false;
	}

	public static boolean areSame(int[] CT, int[] CP) {
		for (int i = 0; i < CHAR; i++) {
			if (CT[i] != CP[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram(String txt, String pat, int i) {
		int count[] = new int[CHAR];
		for (int j = 0; j < pat.length(); j++) {
			count[pat.charAt(j)]++;
			count[txt.charAt(j + i)]--;
		}
		for (int j = 0; j < count.length; j++) {
			if (count[j] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String txt = "geeksforgeeks";
		String pat = "frog";
		if (isPresent2(txt, pat))
			System.out.println("Anagram search found");
		else
			System.out.println("Anagram search not found");
	}

}
