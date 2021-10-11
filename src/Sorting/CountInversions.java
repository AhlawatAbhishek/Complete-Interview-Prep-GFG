package Sorting;

public class CountInversions {
//	Time complexity: O(N^2) and auxiliary space : O(1)
	public static int countInversions(int arr[], int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j])
					count++;
			}
		}
		return count;
	}

//	Time complexity: O(NLogN) and auxiliary space : O(N)
	public static int countInversions1(int arr[], int l, int r) {
		int count = 0;
		if (l < r) {
			int mid = l + (r - l) / 2;
			count += countInversions1(arr, l, mid);
			count += countInversions1(arr, mid + 1, r);
			count += merge(arr, l, mid, r);
		}
		return count;
	}

//	public static int merge(int arr[], int l, int mid, int r) {
//		int i = l, j = mid + 1, output[] = new int[r - l + 1], count = 0, n1 = mid - l + 1, k = 0;
//		while (i <= mid && j <= r) {
//			if (arr[i] <= arr[j]) {
//				output[k++] = arr[i++];
//			} else {
//				output[k++] = arr[j++];
//				count += n1 - i;
//			}
//		}
//		while (i <= mid) {
//			output[k++] = arr[i++];
//		}
//		while (j <= r) {
//			output[k++] = arr[j++];
//		}
//		for (int z = 0; z < output.length; z++) {
//			arr[z + l] = output[z];
//		}
//		return count;
//	}

	static int merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int inversion = 0;
		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				inversion += n1 - i;
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return inversion;
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 2, 4, 1, 3, 5 };

		int n = arr.length;
		System.out.println(countInversions(arr, n));
		System.out.println(countInversions1(arr, 0, n - 1));
	}

}
