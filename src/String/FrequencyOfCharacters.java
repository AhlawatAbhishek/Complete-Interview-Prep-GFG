package String;

public class FrequencyOfCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "geeksforgeeks";
		int freq[] = countFreq(str);
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				System.out.println((char) (i + 'a') + " -> " + freq[i]);
			}
		}
	}

	public static int[] countFreq(String str) {
		int freq[] = new int[26];

		for (char c : str.toCharArray()) {
			freq[c - 'a'] += 1;
		}
		return freq;
	}

}
