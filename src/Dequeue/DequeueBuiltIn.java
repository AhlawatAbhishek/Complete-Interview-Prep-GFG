package Dequeue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeueBuiltIn {
//methods used donot throw exceptions
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> d = new LinkedList<Integer>();
		// Adds element to front of queue
		d.offerFirst(10);

		// Adds element to end of queue
		d.offerLast(20);

		// Adds element to front of queue
		d.offerFirst(5);

		// Adds element to end of queue
		d.offerLast(15);

		Iterator it = d.iterator();
		while (it.hasNext()) {
			System.out.println(it.next() + " ");
		}
		System.out.println();

		for (int x : d) {
			System.out.println(x + " ");
			System.out.println();
		}

//		// Retrieve the head element
//		System.out.println(d.peekFirst());
//
//		// Retrieve the tail element
//		System.out.println(d.peekLast());
//
//		// Retrieve and remove the head element
//		d.pollFirst();
//
//		// Retrieve and remove the tail element
//		d.pollLast();
//
//		System.out.println(d.peekFirst());
//		System.out.println(d.peekLast());

	}

}
