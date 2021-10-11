package Hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 15, 12, 13, 12, 13, 13, 18 };
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int a : arr) {
			hmap.put(a, hmap.getOrDefault(a, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> e : hmap.entrySet()) {
			System.out.println(e.getKey() + " -> " + e.getValue());
		}
	}

}
