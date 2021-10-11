package Arrays;

import java.util.ArrayList;
import java.util.Collections;

//An element is called the leader of an array if there is no element greater than it on the right side.
public class LeadersInArray {
	public static void leaders(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] >= arr[i]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	public static void leaders2(int arr[], int n) {
		int currLead = arr[n - 1];
		ArrayList<Integer> li = new ArrayList<>();
		li.add(currLead);
		for (int i = n - 2; i >= 0; i--) {
			if (currLead < arr[i]) {
				currLead = arr[i];
				li.add(currLead);
			}
		}
		Collections.reverse(li);
		for (int i : li) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 7, 10, 4, 10, 6, 5, 2 }, n = 7;

		leaders(arr, n);
		leaders2(arr, n);
	}

}
