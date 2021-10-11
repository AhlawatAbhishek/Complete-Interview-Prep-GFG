package Arrays;

public class LeftRotateArrayByDPlaces {
	// Time complexity: O(N) and auxiliary space: O(N)
	public static void leftRotate(int arr[], int d, int n) {
		d = d % n;
		int copy[] = new int[n];
		int index = d, i = 0;
		;
		for (i = 0; i < n && index < n; i++) {
			copy[i] = arr[index++];
		}
		index = 0;
		for (; i < n && index < d; i++, index++) {
			copy[i] = arr[index];
		}
		for (i = 0; i < n; i++) {
			arr[i] = copy[i];
		}
	}

	// Time complexity: O(N) and auxiliary space: O(d)
	public static void leftRotate3(int arr[], int d, int n) {
		d = d % n;
		int copy[] = new int[d];
		for (int i = 0; i < d; i++) {
			copy[i] = arr[i];
		}
		for (int i = d; i < n; i++) {
			arr[i - d] = arr[i];
		}
		for (int i = 0; i < d; i++) {
			arr[n - d + i] = copy[i];
		}
	}

	// Time complexity: O(N * d) and auxiliary space: O(1)
	public static void leftRotate4(int arr[], int d, int n) {
		d = d % n;
		for (int i = 0; i < d; i++) {
			leftRotateByOne(arr, n);
		}

	}

	// Time complexity: O(N) and auxiliary space: O(1)
	public static void leftRotateByOne(int arr[], int n) {
		int temp = arr[0];
		for (int i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[n - 1] = temp;
	}

//Time complexity: O(N) and auxiliary space: O(1)
	public static void leftRotate2(int arr[], int d, int n) {
		d = d % n;
		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);
	}

	public static void reverse(int arr[], int l1, int r1) {
		int l = l1, r = r1;
		while (l < r) {
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 }, n = 5, d = 2;

		System.out.println("Before Rotation");

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();

//		leftRotate(arr, d, n);
//		leftRotate2(arr, d, n);
//		leftRotate3(arr, d, n);
		leftRotate4(arr, d, n);
		System.out.println("After Rotation");

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
