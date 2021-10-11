package Arrays;

import java.util.Arrays;

//if array is sorted then the time complexity will be O(N) as there will be no need of sorting the array and space complexity would remain same O(n);
public class RemoveDuplicates {
	public static void main(String args[]) {
		int ar[] = { 10, 10, 20, 20, 30, 30, 30, 30, 50, 70 };
		Arrays.sort(ar);
		int temp = ar[0];
		int index = 0;
		ar[index++] = temp;
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] != temp) {
				temp = ar[i];
				ar[index++] = temp;
			} else {
				continue;
			}
		}
		System.out.println(index);
	}
} // O(n) time complexity and O(1) space complexity
//	public static void main(String args[]) {
//		int ar[] = { 10, 10, 20, 20, 30, 30, 30, 30, 50 };
//		Arrays.sort(ar);
//		int temp = ar[0];
//		ArrayList<Integer> al = new ArrayList<>();
//		al.add(temp);
//		for (int i = 1; i < ar.length; i++) {
//			if (ar[i] != temp) {
//				temp = ar[i];
//				al.add(temp);
//			} else {
//				continue;
//			}
//		}
//		System.out.println(al);
//	}
//}///O(n) solution with n time complexity and O(n) space complexity

//public class RemoveDuplicates {
//	public static void main(String args[]) {
//		int ar[] = { 10, 20, 20, 30, 30, 30, 30 };
//		ArrayList<Integer> al = new ArrayList<>();
//		for (int x : ar) {
//			if (!al.contains(x)) {
//				al.add(x);
//			}
//		}
//		System.out.println(al.size());
//	}
//}
