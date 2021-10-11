package Arrays;

public class MaxConseqOnes {
//	Time complexity: O(N^2) and auxiliary space : 0(1)
	public static int maxConsecutiveOnes(int arr[], int n) {
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			int count = 0;
			if (arr[i] == 1) {
				count++;
				for (int j = i + 1; j < n; j++) {
					if (arr[j] == 1) {
						count++;
					} else {
						break;
					}
				}
				maxLen = Math.max(maxLen, count);
			}
		}
		return maxLen;
	}

//	Time complexity: 0(N) and auxiliary space : 0(1)
	public static int maxConsecutiveOnes1(int arr[], int n) {
		int maxLen = 0, ones = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] == 1) {
				ones++;
			} else {
				ones = 0;
			}
			maxLen = Math.max(maxLen, ones);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 1, 0, 1, 1 }, n = 7;

		System.out.println(maxConsecutiveOnes1(arr, n));

	}

}
