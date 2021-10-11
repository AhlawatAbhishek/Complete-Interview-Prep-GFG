package Arrays;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {
//	Time complexity: O(N*M) and auxiliary space : O(1)
	public static ArrayList<Integer> intersection(int arr[], int brr[], int m, int n) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			if (i > 0 && arr[i - 1] == arr[i]) {
				continue;
			}
			for (int j = 0; j < n; j++) {
				if (arr[i] == brr[j]) {
					al.add(arr[i]);
					break;
				}
			}
		}
		return al;
	}

//	Time complexity: O(N+M) and auxiliary space : O(1)
	public static ArrayList<Integer> intersection1(int arr[], int brr[], int m, int n) {
		ArrayList<Integer> al = new ArrayList<>();
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				i++;
				continue;
			}
			if (arr[i] > brr[j]) {
				j++;
			} else if (arr[i] < brr[j]) {
				i++;
			} else {
				al.add(arr[i]);
				i++;
				j++;
			}
		}
		return al;
	}

	public static void main(String[] args) {
		int a[] = new int[] { 3, 5, 10, 10, 10, 15, 15, 20 };
		int b[] = new int[] { 5, 10, 10, 15, 30 };
		int m = a.length;
		int n = b.length;
		System.out.println(intersection(a, b, m, n));

	}

}
