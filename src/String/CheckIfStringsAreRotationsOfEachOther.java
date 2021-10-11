package String;

public class CheckIfStringsAreRotationsOfEachOther {
	public static boolean areRotations(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		s1 = s1 + "" + s1;
		return (s1.indexOf(s2) >= 0);
	}

//Time complexity : 0(N) and space complexity: 0(N);
	public static void main(String args[]) {
		String s1 = "ABCD";
		String s2 = "CDAB";
		if (areRotations(s1, s2)) {
			System.out.println("Strings are rotations of each other");
		} else {
			System.out.println("Strings are not rotations of each other");
		}
	}

}
