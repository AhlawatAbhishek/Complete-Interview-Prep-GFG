package Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int nums[] = { 20, 10, 20, 8, 12 };
		reverse(nums, 0, nums.length - 1);

		for (int x : nums) {
			System.out.print(x + " ");
		}

	}

	private static void reverse(int nums[], int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
