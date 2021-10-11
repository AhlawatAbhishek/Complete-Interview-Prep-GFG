package CollectionOverview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MoreGeneralizedIteratorExample {
	static void removeEven(Collection<?> C) {
		Iterator<?> it = C.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Integer> C = new ArrayList<>();
		C.add(10);
		C.add(15);
		C.add(20);

		removeEven(C);
		System.out.println(C);
	}

}
