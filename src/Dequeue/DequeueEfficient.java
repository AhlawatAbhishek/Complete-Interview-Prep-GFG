package Dequeue;

public class DequeueEfficient {
	int arr[];
	int front, cap, size;

//Time complexity of all of them is O(1) and space complexity(auxillary space) : O(1)
	DequeueEfficient(int c) {
		this.arr = new int[c];
		this.cap = c;
		this.front = 0;
		this.size = 0;
	}

	boolean isFull() {
		return this.size == this.cap;
	}

	boolean isEmpty() {
		return this.size == 0;
	}

	void insertFront(int x) {
		if (isFull()) {
			return;
		}
		front = (front + cap - 1) % cap;
		arr[front] = x;
		size++;
	}

	void deleteFront() {
		if (isEmpty()) {
			return;
		}
		front = (front + 1) % cap;
		size--;
	}

	void insertRear(int x) {
		if (isFull()) {
			return;
		}
		int new_rear = (this.front + this.size) % this.cap;
		arr[new_rear] = x;
		this.size++;
	}

	void deleteRear() {
		if (isEmpty()) {
			return;
		}
		this.size--;
	}

	int getFront() {
		if (isEmpty()) {
			return -1;
		} else {
			return arr[this.front];
		}
	}

	int getRear() {
		if (isEmpty()) {
			return -1;
		} else {
			return arr[(this.front + this.size - 1) % this.cap];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DequeueEfficient queue = new DequeueEfficient(10);
		queue.insertFront(10);
		queue.insertFront(20);
		queue.insertRear(50);
		queue.insertRear(60);
		System.out.println(queue.getRear());
	}

}
