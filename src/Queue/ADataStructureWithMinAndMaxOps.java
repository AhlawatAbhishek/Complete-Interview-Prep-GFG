package Queue;

import java.util.Deque;
import java.util.LinkedList;

class DataStrct {
	Deque<Integer> deq = new LinkedList<Integer>();

	void insertMin(int x) {
		deq.offerFirst(x);
	}

	void insertMax(int x) {
		deq.offerLast(x);
	}

	int getMax() {
		return deq.peekLast();
	}

	int getMin() {
		return deq.peekFirst();
	}

	int extractMax() {
		return deq.pollLast();
	}

	int extractMin() {
		return deq.pollFirst();
	}
}

public class ADataStructureWithMinAndMaxOps {

	public static void main(String[] args) {
		DataStrct ds = new DataStrct();

		ds.insertMin(10);
		ds.insertMax(15);
		ds.insertMin(5);

		int x = ds.extractMin();
		System.out.println(x);

		x = ds.extractMax();
		System.out.println(x);

		ds.insertMin(8);

	}

}
