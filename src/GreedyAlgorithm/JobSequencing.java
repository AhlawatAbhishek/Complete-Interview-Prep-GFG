package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {

	char id;
	int deadLine, profit;

	public JobSequencing() {
		char id;
		int deadline, profit;
	}

	public JobSequencing(char id, int deadLine, int profit) {
		this.id = id;
		this.deadLine = deadLine;
		this.profit = profit;
	}

//	t is jobs to sequences
//	Time complexity : O(N^2) and space complexity : O(2t) 
	void printJobScheduling(ArrayList<JobSequencing> arr, int t) {
		int n = arr.size();
		Collections.sort(arr, (a, b) -> b.profit - a.profit);
		boolean result[] = new boolean[t];
		char job[] = new char[t];
		for (int i = 0; i < n; i++) {
			for (int j = Math.min(t - 1, arr.get(i).deadLine - 1); j >= 0; j--) {
				if (result[j] == false) {
					result[j] = true;
					job[j] = arr.get(i).id;
					break;
				}
			}
		}
		for (char ch : job) {
			System.out.print(ch + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayList<JobSequencing> arr = new ArrayList<JobSequencing>();

		arr.add(new JobSequencing('a', 2, 100));
		arr.add(new JobSequencing('b', 1, 19));
		arr.add(new JobSequencing('c', 2, 27));
		arr.add(new JobSequencing('d', 1, 25));
		arr.add(new JobSequencing('e', 3, 15));

		// Function call
		System.out.println("Following is maximum " + "profit sequence of jobs");

		JobSequencing job = new JobSequencing();

		// Calling function
		job.printJobScheduling(arr, 3);
	}

}
