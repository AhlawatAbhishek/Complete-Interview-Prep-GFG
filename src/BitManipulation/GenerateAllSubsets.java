package BitManipulation;

public class GenerateAllSubsets {
// Subsequence and subsets are same zero or more words maintaining the order and they need
//	not to be contiguous, while substring and subArray maintain order and are contiguous
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		printAllSubsets(s);
	}

//Time complexity: 0(2^n * n) and space complexity or auxiliary space: O(1)
	public static void printAllSubsets(String s) {
		int n = s.length();
		int powerSets = (int) Math.pow(2, n);
		for (int count = 0; count < powerSets; count++) {
			for (int j = 0; j < n; j++) {
				if ((count & (1 << j)) != 0) {
					System.out.print(s.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
