package Arrays;

import java.util.Arrays;

public class NBonnaciNumbers {
//	Time complexity: O(M) and auxiliary space: O(m)
	public static void bonacciseries(int n, int m) {
		int res[] = new int[m];
		Arrays.fill(res, 0);
		res[n - 1] = 1;
		res[n] = 1;
		for (int i = n + 1; i < m; i++) {
			res[i] = 2 * res[i - 1] - res[i - n - 1];
		}
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int N = 5, M = 15;
		bonacciseries(N, M);

	}

}
