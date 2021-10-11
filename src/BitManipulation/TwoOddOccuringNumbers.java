package BitManipulation;

public class TwoOddOccuringNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 3, 4, 3, 4, 5, 4, 4, 6, 7, 7 };
		int res[] = findTheTwoOdds(arr);
		System.out.println(res[0] + " " + res[1]);
		findNumbers(arr);
	}

//	Time Complexity: O(N^2) and space complexity or auxiliary space : O(2) if array 
//	is output and O(1) if we direct print the values of the numbers
	public static int[] findTheTwoOdds(int arr[]) {
		int res[] = new int[2], index = 0;
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (num == arr[j]) {
					count++;
				}
			}
			if (count % 2 != 0) {
				res[index++] = num;
			}
		}
		return res;
	}

//    Time complexity O(N) and space complexity: O(1);
	public static void findNumbers(int arr[]) {
		int XOR = 0, res1 = 0, res2 = 0;
		for (int i : arr) {
			XOR = XOR ^ i;
		}
		int rightMostSetBit = XOR & (~(XOR - 1));
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & rightMostSetBit) != 0) {
				res1 = res1 ^ arr[i];
			} else {
				res2 = res2 ^ arr[i];
			}
		}
		System.out.println(res1 + " " + res2);
	}
}
