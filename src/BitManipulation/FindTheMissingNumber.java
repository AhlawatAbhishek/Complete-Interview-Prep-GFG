package BitManipulation;

public class FindTheMissingNumber {
	/*
	 * Given an array of n numbers that has values in range [1...n+1]. Every no.
	 * appears exactly one. Hence one no. is missing. Find the missing no.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 4, 3 };
		System.out.println(findNumber(arr));
	}

	public static int findNumber(int arr[]) {
		int res = 0;
		for (int i : arr) {
			res = res ^ i;
		}
		for (int i = 1; i <= arr.length + 1; i++) {
			res = res ^ i;
		}
		return res;
	}
}
