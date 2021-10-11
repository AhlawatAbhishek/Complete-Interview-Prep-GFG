package String;

public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABCDDCBA";
		System.out.println(isPalindrome(str));
	}

	public static boolean isPalindrome(String str) {
		int start = 0, end = str.length() - 1;
		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static boolean isPalindrome1(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		return str.equals(sb.toString());
	}

}
