package Stack;

import java.util.Arrays;

class kStacks {
	int top[], next[], arr[], freeTop, k, cap;

	kStacks(int k1, int capp) {
		this.k = k1;
		this.cap = capp;
		arr = new int[this.cap];
		top = new int[k];
		next = new int[this.cap];
		Arrays.fill(top, -1);
		for (int i = 0; i < this.cap - 1; i++) {
			next[i] = i + 1;
		}
		next[this.cap - 1] = -1;
	}

	boolean isEmpty(int s) {
		return top[s] == -1;
	}

	boolean isFull() {
		return freeTop == -1;
	}

	public void push(int data, int s) {
		if (isFull()) {
			System.out.println("Stack overflow");
			return;
		}
		int i = freeTop;
		arr[i] = data;
		freeTop = next[i];
		next[i] = top[s];
		top[s] = i;

	}

	public int pop(int s) {
		if (isEmpty(s)) {
			System.out.println("Stack underflow");
			return -1;
		}
		int t = top[s];
		int newTop = next[t];
		next[t] = freeTop;
		top[s] = newTop;
		freeTop = t;
		return arr[t];
	}
}

public class KStackss {

	public static void main(String[] args) {

		int k = 3, n = 10;
		kStacks ks = new kStacks(k, n);

		ks.push(15, 2);
		ks.push(45, 2);

		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));

	}

}
