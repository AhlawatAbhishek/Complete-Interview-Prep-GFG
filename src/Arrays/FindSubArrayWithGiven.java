package Arrays;

public class FindSubArrayWithGiven {
//	Time complexity: O(N) and auxiliary space: O(1)
	public int subArraySum(int arr[], int n, int sum) {
		int end = 1, start = 0, currSum = arr[0];
		while (end <= n) {
			if (currSum > sum && start - 1 < end) {
				currSum -= arr[start];
				start++;
			}
			if (currSum == sum) {
				System.out.println("Sum found from " + start + " to " + (end - 1));
				return 1;
			}
			if (end < n)
				currSum += arr[end];
			end++;
		}
		System.out.println("Not found");
		return 0;
	}

	public int subArraySum1(int arr[], int n, int sum) {
		int end = 0, start = 0, currSum = 0;
		while (end <= n) {
			if (currSum > sum && start - 1 < end) {
				currSum -= arr[start];
				start++;
			}
			if (currSum == sum) {
				System.out.println("Sum found from " + start + " to " + (end - 1));
				return 1;
			}
			if (end < n)
				currSum += arr[end];
			end++;
		}
		System.out.println("Not found");
		return 0;
	}

	public static void main(String[] args) {
		FindSubArrayWithGiven arraysum = new FindSubArrayWithGiven();
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int n = arr.length;
		int sum = 23;
		arraysum.subArraySum(arr, n, sum);
	}

}
