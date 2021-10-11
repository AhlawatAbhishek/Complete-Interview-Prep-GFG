package Stack;

import java.util.Stack;

public class LargestRectangleWithAllOnes {
//	Time complexity : 0(R*C) and space complexity or auxiliary space: O(N)
	public static int maxRectangle(int R, int C, int[][] A) {
		int maxArea = maxHistogram(A[0]);
		for (int i = 1; i < R; i++) {
			for (int j = 0; j < R; j++) {
				if (A[i][j] == 1) {
					A[i][j] += A[i - 1][j];
				}
			}
			maxArea = Math.max(maxArea, maxHistogram(A[i]));
		}
		return maxArea;
	}

//	Time complexity : 0(N) and space complexity or auxiliary space: O(N)
	public static int maxHistogram(int arr[]) {
		int maxArea = 0;
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				int top = arr[st.pop()];
				int currArea = top * (st.isEmpty() ? i : (i - st.peek() - 1));
				maxArea = Math.max(currArea, maxArea);
			}
			st.push(i);
		}
		while (!st.isEmpty()) {
			int top = arr[st.pop()];
			int currArea = top * (st.isEmpty() ? n : (n - st.peek() - 1));
			maxArea = Math.max(currArea, maxArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int R = 4;
		int C = 4;

		int A[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, };
		System.out.print("Area of maximum rectangle is " + maxRectangle(R, C, A));
	}

}
