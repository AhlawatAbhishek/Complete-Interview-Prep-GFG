package Dequeue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeueBuiltInAndThrowingException {
//this methods throw exceptions when something goes wrong like deleting from and empty queue.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> d = new LinkedList<Integer>();

		// Adds element to front of queue
		d.addFirst(10);

		// Adds element to end of queue
		d.addLast(20);

		// Adds element to front of queue
		d.addFirst(5);

		// Adds element to end of queue
		d.addLast(15);
		Iterator it = d.descendingIterator();
		while (it.hasNext()) {
			System.out.println(it.next() + " ");

		}
//		// Retrieve the head element
//		System.out.println(d.getFirst());
//
//		// Retrieve the tail element
//		System.out.println(d.getLast());
//
//		// Retrieve and remove the head element
//		d.removeFirst();
//
//		// Retrieve and remove the tail element
//		d.removeLast();
//
//		System.out.println(d.getFirst());
//		System.out.println(d.getLast());
	}

}
