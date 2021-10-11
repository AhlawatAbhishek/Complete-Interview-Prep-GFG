package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumSwapsRequiredToSortTheArray {
//	public static int minSwaps(int nums[]) {
//		// Code here
//		int n = nums.length;
//		int[] temp = Arrays.copyOfRange(nums, 0, n);
//		Arrays.sort(temp);
//		int count = 0;
//		for (int i = 0; i < n; i++) {
//			if (temp[i] != nums[i]) {
//				count++;
//				swap(nums, i, indexOf(nums, temp[i]));
//			}
//		}
//		return count;
//	}
//
//	public static int indexOf(int arr[], int key) {
//		for (int i = 0; i < arr.length; i++) {
//			if (key == arr[i]) {
//				return i;
//			}
//		}
//		return -1;
//	}
//
//	public static void swap(int nums[], int i, int j) {
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
//	}
//Below is graph approach for the question pair is in javafx.util package
	static class Pair<T, E> {
		T key;
		E value;

		Pair(T key, E value) {
			this.key = key;
			this.value = value;
		}

		T getKey() {
			return this.key;
		}

		E getValue() {
			return this.value;
		}
	}

	public static int minSwaps(int nums[]) {
		// Code here
		int ans = 0;
		ArrayList<Pair<Integer, Integer>> arrpos = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			arrpos.add(new Pair<Integer, Integer>(nums[i], i));
		}
		boolean visited[] = new boolean[nums.length];
		Collections.sort(arrpos, (a, b) -> a.getKey() - b.getKey());
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] || i == arrpos.get(i).getValue()) {
				continue;
			}
			int cycle = 0;
			int j = i;
			while (!visited[j]) {
				visited[j] = true;
				j = arrpos.get(j).getValue();
				cycle++;
			}
			if (cycle > 0) {
				ans += cycle - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 19, 6, 3, 5 };
		System.out.println(minSwaps(nums));
	}

}
