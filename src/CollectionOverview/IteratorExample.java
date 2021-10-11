package CollectionOverview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorExample {
	static void removeEven(Collection<Integer> C) {
		Iterator<Integer> it = C.iterator();
		while (it.hasNext()) {
			int x = (Integer) it.next();
			if (x % 2 == 0) {
				it.remove();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Integer> c = new ArrayList<Integer>();

		c.add(10);
		c.add(15);
		c.add(20);
		removeEven(c);
		System.out.println(c);
	}

}
