package Arrays;

public class LeftRotateByOne {
	public static void main(String args[]) {
		int arr[] = { 30, 5, 20 };
		int temp = arr[0];
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[index++] = arr[i];
		}
		arr[index] = temp;
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
