package CollectionOverview;

import java.util.ArrayList;
import java.util.List;

public class toArrayUsingGenericMethod {
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		Integer[] arr = new Integer[list.size()];
		arr = list.toArray(arr);
		for (Integer x : arr) {
			System.out.println(x + " ");
		}
	}
}
