package Stack;

import java.util.Stack;

public class LargestRectangularAreaInAHistogram {
//	Time complexity : 0(N^2) and space complexity or auxiliary space: O(1)
	public static int getMaxArea(int arr[], int n) {
		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			int currArea = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] >= arr[i]) {
					currArea += arr[i];
				} else {
					break;
				}
			}
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= arr[i]) {
					currArea += arr[i];
				} else {
					break;

				}
			}
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}

//	Time complexity : 0(N) and space complexity or auxiliary space: O(N)
	public static int getMaxArea2(int arr[], int n) {
		int maxArea = 0;
		int ps[] = new int[n], ns[] = new int[n];
		Stack<Integer> st = new Stack<>();
		st.add(0);
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			int pse = st.isEmpty() ? -1 : st.peek();
			ps[i] = pse;
			st.add(i);
		}
		while (!st.isEmpty()) {
			st.pop();
		}
//		if (n >= 1)
		st.push(n - 1);
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			int nse = st.isEmpty() ? n : st.peek();
			ns[i] = nse;
			st.add(i);
		}
		for (int i = 0; i < n; i++) {
			int currArea = arr[i];
			currArea += (i - ps[i] - 1) * arr[i];
			currArea += (ns[i] - i - 1) * arr[i];
			maxArea = Math.max(maxArea, currArea);
		}
		return maxArea;
	}

//	Time complexity : 0(N) and space complexity or auxiliary space: O(N)
	public static int getMaxArea3(int arr[], int n) {
		int maxArea = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				int top = st.pop();
				int curr = arr[top] * (st.isEmpty() ? i : (i - st.peek() - 1));
				maxArea = Math.max(curr, maxArea);
			}
			st.add(i);
		}
		while (!st.isEmpty()) {
			int top = st.pop();
			int curr = arr[top] * (st.isEmpty() ? n : (n - st.peek() - 1));
			maxArea = Math.max(curr, maxArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 6, 2, 5, 4, 1, 5, 6 };

		System.out.print("Maximum Area: " + getMaxArea3(arr, arr.length));
	}

}
