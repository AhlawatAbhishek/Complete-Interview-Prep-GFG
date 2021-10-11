package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Triplet {
	int ap, vp, value;

	Triplet(int ap, int vp, int val) {
		this.ap = ap;
		this.vp = vp;
		this.value = val;
	}
}

public class MergeKSortedArrays {
//	k - number of arrays, n - length of longest array
//	Time complexity: O(n*k log(n*k)) and auxiliary space O(n*k)
	public static ArrayList<Integer> mergeKArrays(ArrayList<ArrayList<Integer>> arr) {
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			for (int j : arr.get(i)) {
				res.add(j);
			}
		}
		Collections.sort(res);
		return res;
	}

	/*
	 * k number of arrays, n length of longest array Time complexity: O(n*k log(k))
	 * and auxiliary space O(k)
	 */
	public static ArrayList<Integer> mergeKArrays3(ArrayList<ArrayList<Integer>> arr) {
		ArrayList<Integer> res = new ArrayList<>();
		Queue<Triplet> queue = new PriorityQueue<>((a, b) -> a.value - b.value);
		for (int i = 0; i < arr.size(); i++) {
			queue.offer(new Triplet(i, 0, arr.get(i).get(0)));
		}
		while (!queue.isEmpty()) {
			Triplet t = queue.poll();
			int ap = t.ap, vp = t.vp, val = t.value;
			res.add(val);
			if (vp + 1 < arr.get(ap).size()) {
				queue.offer(new Triplet(ap, vp + 1, arr.get(ap).get(vp + 1)));
			}
		}
		return res;
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		int i = 0, j = 0;
		ArrayList<Integer> res = new ArrayList<>();
		while (i < l1.size() && j < l2.size()) {
			if (l1.get(i) > l2.get(j)) {
				res.add(l2.get(j));
				j++;
			} else {
				res.add(l1.get(i));
				i++;
			}
		}
		if (l1.size() > i) {
			while (i < l1.size()) {
				res.add(l1.get(i));
				i++;
			}
		}
		if (j < l2.size()) {
			while (j < l2.size()) {
				res.add(l2.get(j));
				j++;

			}
		}
		return res;
	}

//	k - number of arrays, n - length of longest array
//	Time complexity: O(n*k^2)) and auxiliary space O(n*k)
	public static ArrayList<Integer> mergeKArrays2(ArrayList<ArrayList<Integer>> arr) {
		ArrayList<Integer> res = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			res = merge(arr.get(i), res);
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(10);
		a1.add(20);
		a1.add(30);
		arr.add(a1);

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(5);
		a2.add(15);
		arr.add(a2);

		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(1);
		a3.add(9);
		a3.add(11);
		a3.add(18);
		arr.add(a3);

		ArrayList<Integer> res = mergeKArrays3(arr);

		System.out.println("Merged array is ");
		for (int x : res)
			System.out.print(x + " ");

	}

}
