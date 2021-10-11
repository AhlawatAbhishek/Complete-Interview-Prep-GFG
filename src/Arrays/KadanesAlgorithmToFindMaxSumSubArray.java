package Arrays;

public class KadanesAlgorithmToFindMaxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long maximumSum(int arr[], int sizeOfArray) {
		// print corresponding values and at the end print next line and return the
		// maximum sum

		long maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
		for (int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
			System.out.print(maxEndingHere + " ");
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}

		}
		System.out.println();
		return maxSoFar;
	}

}
