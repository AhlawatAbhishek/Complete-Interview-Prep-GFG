package BackTracking;

public class BlackAndWhiteKnighr {
	/*
	 * Given the chessboard dimensions. Find out the number of ways we can place a
	 * black and a white Knight on this chessboard such that they cannot attack each
	 * other.
	 * 
	 * Note: The knights have to be placed on different squares. A knight can move
	 * two squares horizontally and one square vertically (L shaped), or two squares
	 * vertically and one square horizontally (L shaped). The knights attack each
	 * other if one can reach the other in one move.
	 * 
	 * Example 1:
	 * 
	 * Input: N = 2,M = 2 Output: 12
	 */
	static long solve(int N, int M) {
		// add your code here
		int mod = 1000000007;
		long notPossiblePos = 0;
		int[] X = { 1, 2, -1, -2, -2, -1, 1, 2 };
		int[] Y = { 2, 1, 2, 1, -1, -2, -2, -1 };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 8; k++) {
					int xCor = i + X[k];
					int yCor = j + Y[k];
					if (!(xCor < 0 || xCor >= N || yCor < 0 || yCor >= M)) {
						notPossiblePos = notPossiblePos % mod + 1;
					}
				}
			}
		}

		// totalPossiblities
		long total = N * M;
		// waysOfPlacingTwoNightsinTotalPOssibilities without considering attacks tota;
		// C 1 && total - 1 C 1;
		long ways = (total % mod * (total % mod - 1)) % mod;
		return (ways % mod - notPossiblePos % mod);
	}
}
