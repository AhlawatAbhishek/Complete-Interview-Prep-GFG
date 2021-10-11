package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class PossibleWordsFromPhoneDigits {
	// String array to store keypad characters
	static String hash[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	static ArrayList<String> possibleWords(int a[], int N) {
		String str = "";
		for (int i = 0; i < N; i++)
			str += a[i];
		ArrayList<String> res = possibleWordsUtil(str);
		Collections.sort(res); // arrange all possible strings lexicographically
		return res;

	}

	static ArrayList<String> possibleWordsUtil(String str) {
		// If str is empty
		if (str.length() == 0) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");

			// Return an Arraylist containing
			// empty string
			return baseRes;
		}

		// First character of str
		char ch = str.charAt(0);

		// Rest of the characters of str
		String restStr = str.substring(1);

		// get all the combination
		ArrayList<String> prevRes = possibleWordsUtil(restStr);
		ArrayList<String> Res = new ArrayList<>();

		String code = hash[ch - '0'];

		for (String val : prevRes) {

			for (int i = 0; i < code.length(); i++) {
				Res.add(code.charAt(i) + val);
			}
		}
		return Res;
	}
	/*
	 * My solution static ArrayList <String> possibleWords(int a[], int N) { // your
	 * code here String [] numPad = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO",
	 * "PQRS", "TUV", "WXYZ"}; Set <String> res = new HashSet <>();
	 * subString(numPad, a, N, res, "", 0); ArrayList <String> result = new
	 * ArrayList <>(); for(String s : res){ result.add(s); }
	 * Collections.sort(result); return result; } public static void
	 * subString(String []numPad, int [] a, int N, Set <String> res, String ssof,
	 * int index){ if( N == index){ if(ssof.length() == N )
	 * res.add(ssof.toLowerCase()); return; } String s = numPad[a[index]]; for(int i
	 * = 0; i<=2; i++){ char cc = s.charAt(i); subString(numPad, a, N, res, ssof+cc,
	 * index+1); // subString(numPad, a, N, res, ssof, index+1); }
	 * 
	 * }
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
