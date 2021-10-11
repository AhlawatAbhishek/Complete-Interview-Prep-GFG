package Dequeue;

public class DequeueUsingArraySimpleImplemetation {
	int arr[];
	int capacity;
	int size;
	int front, rear;

	public DequeueUsingArraySimpleImplemetation(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
		this.size = this.front = this.rear = 0;
	}

	boolean isFull() {
		return this.size == this.capacity;
	}

	boolean isEmpty() {
		return this.size == 0;
	}

	void insertRear(int x) {
		if (isFull()) {
			return;
		}
		this.arr[size] = x;
		size++;
	}

	int deleteRear() {
		if (isEmpty()) {
			return -1;
		}
		int item = this.arr[rear];
		size--;
		return item;
	}

	int getRear() {
		if (isEmpty()) {
			return -1;
		} else {
			return (size - 1);
		}
	}

	void insertFront(int x) {
		if (isFull()) {
			return;
		}
		for (int i = 0; i < this.size; i++) {
			this.arr[i + 1] = arr[i];
		}
		this.arr[0] = x;
		this.size++;
	}

	void deleteFront() {
		if (isEmpty()) {
			return;
		}
		for (int i = 0; i < this.size; i++) {
			arr[i] = arr[i + 1];
		}
		size--;
	}

	int getFront() {
		if (isEmpty()) {
			return -1;
		} else {
			return 0;
		}
	}

	public static void main(String args[]) {
		DequeueUsingArraySimpleImplemetation queue = new DequeueUsingArraySimpleImplemetation(10);
		queue.insertFront(10);
		queue.insertFront(20);
		queue.insertRear(50);
		queue.insertRear(60);
		System.out.println(queue.deleteRear());

	}
}
