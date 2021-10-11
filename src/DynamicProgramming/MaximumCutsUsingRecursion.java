package DynamicProgramming;

public class MaximumCutsUsingRecursion {
	// Time complexity: theta(3^N) and space complexity or auxiliary space :
	static int maxCuts(int n, int a, int b, int c) {
		if (n < 0) {
			return -1;
		}
		if (n == 0) {
			return 0;
		}
		int res = Math.max(maxCuts(n - a, a, b, c), Math.max(maxCuts(n - c, a, b, c), maxCuts(n - c, a, b, c)));
		if (res == -1) {
			return res;
		} else {
			return (res + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5, a = 1, b = 2, c = 3;

		System.out.println(maxCuts(n, a, b, c));
	}

}
