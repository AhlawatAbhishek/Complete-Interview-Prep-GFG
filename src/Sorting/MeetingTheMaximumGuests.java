package Sorting;

import java.util.Arrays;

public class MeetingTheMaximumGuests {
//	Time complexity: O(nLogn) and auxiliary space: O(1)
	public static int maxGuest(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 1, j = 0, count = 1, max = 1;
		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				i++;
				count++;
			} else {
				count--;
				j++;
			}
			max = Math.max(count, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 900, 600, 700 };
		int dep[] = { 1000, 800, 730 };
		int n = arr.length;

		System.out.print(maxGuest(arr, dep, n));
	}

}
