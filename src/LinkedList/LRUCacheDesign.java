package LinkedList;

import java.util.HashMap;

//Time complexity in Case of both Hit And Miss is O(1) and space complexity is O(N + N);
public class LRUCacheDesign {
	static class Node {
		int key;
		int data;
		Node next;
		Node prev;

		Node(int k, int v) {
			this.key = k;
			data = v;
			next = null;
		}
	}

	private HashMap<Integer, Node> map;
	private Node head;
	private Node tail;
	private int capacity, count;

	LRUCacheDesign(int capacity) {
		this.capacity = capacity;
		this.head = new Node(0, 0);
		this.tail = new Node(0, 0);
		this.count = 0;
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
		this.map = new HashMap<>();
	}

	public void deleteNode(Node n) {
		n.prev.next = n.next;
		if (n.next != null)
			n.next.prev = n.prev;
	}

	public void addToHead(Node n) {
		n.next = head.next;
		if (n.next != null)
			n.next.prev = n;
		n.prev = head;
		head.next = n;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			int res = n.data;
			deleteNode(n);
			addToHead(n);
			System.out.println("Got the value : " + res + " for the key: " + key);
			return res;
		}
		System.out.println("Did not get any value" + " for the key: " + key);
		return -1;
	}

	public void set(int key, int value) {
		System.out.println("Going to set the (key, " + "value) : (" + key + ", " + value + ")");
		if (map.containsKey(key)) {
			Node n = map.get(key);
			n.data = value;
			map.put(key, n);
			deleteNode(n);
			addToHead(n);
		} else {
			Node n = new Node(key, value);
			map.put(key, n);
			if (count < capacity) {
				count++;
				addToHead(n);
			} else {
				map.remove(tail.prev.key);
				deleteNode(tail.prev);
				addToHead(n);
			}

		}
	}

	public static void main(String[] args) {
		LRUCacheDesign cache = new LRUCacheDesign(2);

		// it will store a key (1) with value
		// 10 in the cache.
		cache.set(1, 10);

		// it will store a key (2) with value 20 in the cache.
		cache.set(2, 20);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

		// removing key 2 and store a key (3) with value 30 in the cache.
		cache.set(3, 30);

		System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)

		// removing key 1 and store a key (4) with value 40 in the cache.
		cache.set(4, 40);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
		System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
		System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40
	}

}
