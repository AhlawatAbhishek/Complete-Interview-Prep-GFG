package Sorting;

public class SortAnArrayWithThreeTypesOfELements {
//	self solution
//	Time complexity: O(N) and auxiliary space: O(1)
	public static void sort1(int arr[], int n) {
		int i = 0, j = n - 1;
		while (true) {
			while (arr[i] <= 1) {
				i++;
			}
			while (arr[j] == 2) {
				j--;
			}
			if (i >= j) {
				break;
			}
			swap(arr, i, j);
		}
		i = 0;
		j = n - 1;
		while (true) {
			while (arr[i] == 0) {
				i++;
			}
			while (arr[j] >= 1) {
				j--;
			}
			if (i >= j) {
				return;
			}
			swap(arr, i, j);
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

//	Time complexity: O(N) and auxiliary space: O(N)
	public static void sortNaive(int arr[], int n) {
		int index = 0, temp[] = new int[n];
		for (int i : arr) {
			if (i == 0) {
				temp[index++] = i;
			}
		}
		for (int i : arr) {
			if (i == 1) {
				temp[index++] = i;
			}
		}
		for (int i : arr) {
			if (i == 2) {
				temp[index++] = i;
			}
		}
		for (int i = 0; i < n; i++) {
			arr[i] = temp[i];
		}
	}

//	Time complexity: O(N) and auxiliary space: O(1)
	public static void sortUsingDutchFlagAlgo(int ar[], int n) {
		int lo = 0, mid = 0, hi = n - 1;
		while (mid <= hi) {
			if (ar[mid] == 0) {
				swap(ar, mid, lo);
				mid++;
				lo++;
			} else if (ar[mid] == 1) {
				mid++;
			} else {
				swap(ar, mid, hi);
				hi--;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 0, 1, 1, 2, 0, 1, 1, 2 };

		int n = arr.length;

//		sort1(arr, n);
//		sortNaive(arr, n);
		sortUsingDutchFlagAlgo(arr, n);

		for (int x : arr)
			System.out.print(x + " ");

	}
}
