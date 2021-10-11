package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
/*
 * Given an array of integers and a sum B, find all unique combinations in the array where the sum is equal to B. The same number may be chosen from the array any number of times to make B.

Note:
        1. All numbers will be positive integers.
        2. Elements in a combination (a1, a2, …, ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        3. The combinations themselves must be sorted in ascending order.


Example 1:

Input:
N = 4
arr[] = {7,2,6,5}
B = 16
Output:
(2 2 2 2 2 2 2 2)
(2 2 2 2 2 6)
(2 2 2 5 5)
(2 2 5 7)
(2 2 6 6)
(2 7 7)
(5 5 6)
Example 2:

Input:
N = 11
arr[] = {6,5,7,1,8,2,9,9,7,7,9}
B = 6
Output:
(1 1 1 1 1 1)
(1 1 1 1 2)
(1 1 2 2)
(1 5)
(2 2 2)
(6)
 * */

public class CombinationalSum {

	static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		// add your code here
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> D = new ArrayList<>();

		for (Integer x : A) {
			if (!D.contains(x))
				D.add(x);
		}
		Collections.sort(D);

		// findPairs(D, 0, res, B, new ArrayList<>());
		findPairs(D, 0, res, new ArrayList<>(), B);
		return res;
	}

	public static void findPairs(ArrayList<Integer> arr, int index, ArrayList<ArrayList<Integer>> res, int target,
			ArrayList<Integer> curr) {
		if (index >= arr.size()) {
			if (target == 0) {
				res.add(new ArrayList<Integer>(curr));
			}
			return;
		}

		if (arr.get(index) <= target) {
			curr.add(arr.get(index));
			findPairs(arr, index, res, target - arr.get(index), curr);
			curr.remove(curr.size() - 1);
		}
		findPairs(arr, index + 1, res, target, curr);
	}

	public static void findPairs(ArrayList<Integer> arr, int index, ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> curr, int target) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<Integer>(curr));
		}

		for (int i = index; i < arr.size(); i++) {
			curr.add(arr.get(i));
			findPairs(arr, i, res, curr, target - arr.get(i));
			curr.remove(curr.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
