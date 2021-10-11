package BitManipulation;

public class FindTheOnlyOddOccuringNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 4, 3, 4, 4, 4, 5, 5 };
		System.out.println(findNumber(arr));
		System.out.println(findNumberr(arr));
	}

//	Time complexity : O(n^2) and space complexity: O(1)
	public static int findNumber(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			int num = arr[i];
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == num) {
					count++;
				}
			}
			if (count % 2 != 0) {
				return num;
			}
		}
		return -1;
	}

//    Time Complexity: O(n) and space complexity or auxiliary space: O(1)
	public static int findNumberr(int arr[]) {
		/*
		 * properties of XOR: X ^ 0 = X; X ^ Y = Y ^ X; X^(Y^Z) = (X^Y)^Z X ^ X = 0;
		 */
		int res = 0;
		for (int i : arr) {
			res = res ^ i;
		}
		return res;
	}
}
