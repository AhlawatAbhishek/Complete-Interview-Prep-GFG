package Recursion;

public class PrintAllPermutations {
	public static void permute(char[] s, int i) {
		if (i == s.length - 1) {
			System.out.println(new String(s));
			return;
		}
		for (int j = i; j < s.length; j++) {
			swap(s, i, j);
			permute(s, i + 1);
			swap(s, i, j);
		}
	}

	public static void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABC";
		permute(s.toCharArray(), 0);
	}

}
