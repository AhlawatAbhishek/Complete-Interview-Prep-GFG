package Hashing;

import java.util.HashSet;

public class CountDistinctElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 15, 12, 13, 12, 13, 13, 18 };
		HashSet<Integer> hset = new HashSet<>();
		for (int x : arr) {
			hset.add(x);
		}
		System.out.println(hset.size());
	}

}
