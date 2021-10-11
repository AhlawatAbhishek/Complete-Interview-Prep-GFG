package Arrays;

public class MajorityElementOrMooresVotingAlgo {
//	Time complexity: O(N^2) and auxiliary space: 0(1) 
	public static int findMajority(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] == arr[i]) {
					count++;
				}
			}
			if (count > n / 2) {
				return arr[i];
			}
		}
		return -1;
	}

// This method is moore's voting algo
//    Time complexity: O(n) and auxiliary space: 0(1)
	public static int findMajority1(int arr[], int n) {
		int currEle = arr[0], count = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] == currEle) {
				count++;
			} else {
				count--;
				if (count == 0) {
					currEle = arr[i];
					count = 1;
				}
			}
		}
		count = 0;
		for (int i = 0; i < n; i++) {
			if (currEle == arr[i]) {
				count++;
			}
		}
		if (count > n / 2) {
			return currEle;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 8, 7, 6, 8, 6, 6, 6, 6 }, n = 8;

		System.out.println(findMajority1(arr, n));

	}

}
