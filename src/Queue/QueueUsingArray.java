package Queue;

public class QueueUsingArray {
	int front;
	int rear;
	int size;
	int capacity;
	int array[];

	public QueueUsingArray(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1;
		array = new int[this.capacity];
	}

	boolean isFull(QueueUsingArray queue) {
		return (queue.size == queue.capacity);
	}

	boolean isEmpty(QueueUsingArray queue) {
		return (queue.size == 0);
	}

	void enqueue(int item) {
		if (isFull(this)) {
			return;
		}
		this.rear = (this.rear + 1) % this.capacity;
		this.array[this.rear] = item;
		this.size = this.size + 1;
		System.out.println(item + " enqueued to queue");
	}

	int dequeue() {
		if (isEmpty(this)) {
			return Integer.MIN_VALUE;
		}
		int item = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;
		return item;
	}

	int front() {
		if (isEmpty(this)) {
			return Integer.MIN_VALUE;
		}
		return this.array[this.front];
	}

	int rear() {
		if (isEmpty(this)) {
			return Integer.MIN_VALUE;
		}
		return this.array[this.rear];
	}

	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray(1000);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println(queue.dequeue() + " dequeue from queue\n");
		System.out.println("Front item is " + queue.front());
		System.out.println("Rear item is " + queue.rear());
	}

}
