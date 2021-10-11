package Hashing;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoUnsortedArrays {
//	Time complexity : 0(len1+ len2) and space complexity or auxiliary space : O(len1+len2)

	public static int unionSize(int arr1[], int len1, int arr2[], int len2) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		for (int i : arr2) {
			set.add(i);
		}
		return set.size();
	}

	public static void main(String[] args) {
		int arr1[] = new int[] { 2, 8, 3, 5, 6 };
		int arr2[] = new int[] { 4, 8, 3, 6, 1 };
		int m = arr1.length;
		int n = arr2.length;

		System.out.println(unionSize(arr1, m, arr2, n));
	}

}
