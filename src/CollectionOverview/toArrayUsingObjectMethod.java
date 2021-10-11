package CollectionOverview;

import java.util.ArrayList;
import java.util.List;

public class toArrayUsingObjectMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(15);

		Object[] arr = list.toArray();
		Integer[] arrInt = list.toArray(new Integer[0]);
		for (Object x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
		for (Integer x : arrInt) {
			System.out.print(x + " ");
		}
	}

}
