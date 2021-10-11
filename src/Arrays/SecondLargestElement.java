package Arrays;

public class SecondLargestElement {
	public static void main(String args[]) {
		int nums[] = { 20, 10, 20, 8, 12 };
		System.out.println(secondLargest(nums));
	}

	private static int secondLargest(int[] nums) {
		int res = -1, largest = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[largest]) {
				res = largest;
				largest = i;
			} else if (nums[i] != nums[largest]) {
				if (res == -1 || nums[res] < nums[i]) {
					res = i;
				}
			}
		}
		return res;
	}
}
