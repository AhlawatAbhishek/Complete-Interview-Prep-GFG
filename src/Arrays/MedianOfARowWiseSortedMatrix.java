package Arrays;

import java.util.Arrays;

//Assumptions : Odd size matrix and distinct elements
// Naive way: Store all the elements in 1D matrix and then sort it, then return the middle element as median
public class MedianOfARowWiseSortedMatrix {
//	Time complexity: O(log(max-min) * r * log(c)) and auxiliary space: O(1)
	public static int matMed(int arr[][], int r, int c) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = 0; i < r; i++) {
			if (arr[i][0] < min) {
				min = arr[i][0];
			}
			if (arr[i][c - 1] > max) {
				max = arr[i][c - 1];
			}
		}
		int medianPos = (r * c + 1) / 2;
		while (min < max) {
			int mid = (max + min) / 2;
			int midPos = 0, pos = 0;
			for (int i = 0; i < r; i++) {
				pos = Arrays.binarySearch(arr[i], mid);
				if (pos < 0) {
					pos = Math.abs(pos) - 1;
				} else {
					while (pos < arr[i].length && arr[i][pos] == mid) {
						pos += 1;
					}
				}
				midPos = midPos + pos;
			}
			if (midPos < medianPos) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return max;

	}

	public static void main(String[] args) {
		int r = 3, c = 5;
		int m[][] = { { 5, 10, 20, 30, 40 }, { 1, 2, 3, 4, 6 }, { 11, 13, 15, 17, 19 } };
		System.out.println("Median is " + matMed(m, r, c));

	}

}
