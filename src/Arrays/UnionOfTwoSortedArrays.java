package Arrays;

import java.util.Arrays;

public class UnionOfTwoSortedArrays {
//	Time complexity: O((N+M)*Log(N+M)) and auxiliary space: O(N+M)
	public static void printUnion(int a[], int b[], int m, int n) {
		int output[] = new int[n + m];
		for (int i = 0; i < n; i++) {
			output[i] = b[i];
		}
		for (int i = 0; i < m; i++) {
			output[n + i] = a[i];
		}
		Arrays.sort(output);
		System.out.print(output[0] + " ");
		for (int i = 1; i < output.length; i++) {
			if (output[i - 1] != output[i]) {
				System.out.print(output[i] + " ");
			}
		}
		System.out.println();
	}

//	Time complexity: O(N+M) and auxiliary space: O(1)
	public static void printUnion1(int a[], int b[], int m, int n) {
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (i > 0 && a[i] == a[i - 1])
				continue;
			if (j > 0 && b[j] == b[j - 1])
				continue;
			if (a[i] < b[j]) {
				System.out.print(a[i] + " ");
				i++;
			} else if (b[j] < a[i]) {
				System.out.print(b[i] + " ");
				j++;
			} else if (a[i] == b[j]) {
				System.out.print(a[i] + " ");
				i++;
				j++;
			}
		}
		while (i < m) {
			if (a[i - 1] != a[i]) {
				System.out.print(a[i] + " ");
			}
			i++;
		}
		while (j < n) {
			if (b[j - 1] != b[j]) {
				System.out.print(b[j] + " ");
			}
			j++;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int a[] = new int[] { 3, 8, 10 };
		int b[] = new int[] { 2, 8, 9, 10, 15 };

		int m = a.length;
		int n = b.length;
		printUnion1(a, b, m, n);

	}

}
