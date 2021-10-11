package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {
	public static final int CHAR = 256;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "listen";
		String s2 = "silent";
		System.out.println(areAnagram3(s1, s2));
	}

	public static boolean areAnagram(String s1, String s2) {
		HashMap<Character, Integer> freq1 = new HashMap<>();
		HashMap<Character, Integer> freq2 = new HashMap<>();
		for (char c : s1.toCharArray()) {
			freq1.put(c, freq1.getOrDefault(c, 0) + 1);
		}
		for (char c : s2.toCharArray()) {
			freq2.put(c, freq2.getOrDefault(c, 0) + 1);
		}
		for (Map.Entry<Character, Integer> e : freq1.entrySet()) {
			if (e.getValue() != freq2.get(e.getKey())) {
				return false;
			}
		}
		return true;
	}

	public static boolean areAnagram1(String s1, String s2) {
		char ch1[] = s1.toCharArray();
		Arrays.sort(ch1);
		s1 = new String(ch1);

		char ch2[] = s2.toCharArray();
		Arrays.sort(ch2);
		s2 = new String(ch2);
		return s1.equals(s2);
	}

	public static boolean areAnagram3(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int count[] = new int[CHAR];
		for (int i = 0; i < str1.length(); i++) {
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}
		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;

	}
}
