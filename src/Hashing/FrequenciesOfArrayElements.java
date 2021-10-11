package Hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfArrayElements {
//	Time complexity : 0(N) and auxiliary space : O(N) 
	public static void countFreq(int arr[], int n) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int i : arr) {
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 15, 16, 27, 27, 28, 15 };
		int n = arr.length;

		countFreq(arr, n);
	}

}
