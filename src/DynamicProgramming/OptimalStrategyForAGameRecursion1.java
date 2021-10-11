package DynamicProgramming;

public class OptimalStrategyForAGameRecursion1 {
//Time complexity is exponential and auxiliary space used is used for recursion : O(n)	
	static int sol(int arr[], int i, int j) {
		if (j == i + 1) {
			return Math.max(arr[i], arr[j]);
		}
		return Math.max(arr[i] + Math.min(sol(arr, i + 2, j), sol(arr, i + 1, j - 1)),
				arr[j] + Math.min(sol(arr, i + 1, j - 1), sol(arr, i, j - 2)));

	}

	static int mainSol(int arr[], int n) {
		return sol(arr, 0, n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;

		int arr[] = { 20, 5, 4, 6 };

		System.out.println(mainSol(arr, n));
	}

}
