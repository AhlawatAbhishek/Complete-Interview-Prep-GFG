package Queue;

public class QueueUsingLinkedList {
	static class Node {
		int key;
		Node next;

		public Node(int key) {
			this.key = key;
			this.next = null;
		}
	}

	Node front, rear;

	public QueueUsingLinkedList() {
		this.front = this.rear = null;
	}

	void enqueue(int key) {
		Node temp = new Node(key);
		if (this.rear == null) {
			this.front = this.rear = temp;
			return;
		}
		this.rear.next = temp;
		this.rear = temp;
	}

	void dequeue() {
		if (this.front == null) {
			return;
		}
		Node temp = this.front;
		this.front = this.front.next;

		if (this.front == null) {
			this.rear = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingLinkedList q = new QueueUsingLinkedList();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		System.out.println("Queue Front : " + q.front.key);
		System.out.println("Queue Rear : " + q.rear.key);

	}

}
