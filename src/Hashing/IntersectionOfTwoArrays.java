package Hashing;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
//	Time complexity :0(l1 + l2) and space complexity or auxiliary space : O(l1 or l2)
	public static int intersection(int arr1[], int l1, int arr2[], int l2) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		int res = 0;
		for (int i : arr2) {
			if (set.contains(i)) {
				res++;
				set.remove(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr1[] = new int[] { 15, 17, 27, 27, 28, 15 };
		int arr2[] = new int[] { 16, 17, 28, 17, 31, 17 };
		int m = arr1.length;
		int n = arr2.length;

		System.out.println(intersection(arr1, m, arr2, n));
	}

}
