package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> al = new ArrayList<>();
		String str = "ABC";
//		getSubset(str, al, new ArrayList<>(), 0);
//		System.out.println(al);
		printSubsett(str, "", 0);
	}

	public static void getSubset(String s, List<List<String>> subset, ArrayList<String> curr, int index) {

		if (curr.size() >= 0)
			subset.add(new ArrayList(curr));
		for (int i = index; i < s.length(); i++) {
			curr.add(s.charAt(i) + "");
			getSubset(s, subset, curr, i + 1);
			curr.remove(curr.size() - 1);
		}
	}

	public static void printSubsett(String str, String curr, int index) {
		if (index == str.length()) {
			System.out.print(curr + ", ");
			return;
		}
		printSubsett(str, curr, index + 1);
		printSubsett(str, curr + str.charAt(index), index + 1);
	}
}
