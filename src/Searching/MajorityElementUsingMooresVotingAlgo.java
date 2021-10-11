package Searching;

public class MajorityElementUsingMooresVotingAlgo {
//	Time complexity : O(N^2) and auxiliary space: O(1)
	public static int findMajority(int arr[], int n) {
		int res = -1;
		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count > n / 2) {
				res = arr[i];
			}
		}
		return res;
	}

//Moore's Voting Algo
//	Time complexity : O(N) and auxiliary space: O(1)
	public static int findMajority1(int arr[], int n) {
		int res = findCandidate(arr, n);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == res) {
				count++;
			}
			if (count > n / 2) {
				return res;
			}
		}
		return -1;
	}

	public static int findCandidate(int arr[], int n) {
		int res = 0, count = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[res]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				count = 1;
				res = i;
			}
		}
		return arr[res];
	}

	public static void main(String[] args) {
		int arr[] = { 8, 7, 6, 8, 6, 6, 6, 6 }, n = 8;
		System.out.println(findMajority(arr, n));
		System.out.println(findMajority1(arr, n));
	}

}
