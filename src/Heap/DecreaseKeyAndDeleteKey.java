package Heap;

public class DecreaseKeyAndDeleteKey {
	public static class MinHeap {
		int arr[];
		int size;
		int capacity;

		MinHeap(int c) {
			size = 0;
			capacity = c;
			arr = new int[c];
		}

		int left(int i) {
			return (2 * i + 1);
		}

		int right(int i) {
			return (2 * i + 2);
		}

		int parent(int i) {
			return (i - 1) / 2;
		}

//time complexity : O(log(size)) and space complexity(auxiliary space) : O(1)
		public void insert(int x) {
			if (size == capacity) {
				return;
			}
			size++;
			arr[size - 1] = x;
			for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
				int temp = arr[i];
				arr[i] = arr[parent(i)];
				arr[parent(i)] = temp;
				i = parent(i);
			}
		}

		// time complexity : O(log(n)) (logn = h) and space complexity(auxiliary space)
		// : O(1) if it is iterative
//		and O(h) if recursive like the one below.
		public void minHeapify(int i) {
			int lt = left(i);
			int rt = right(i);
			int smallest = i;
			if (lt < size && arr[lt] < arr[i]) {
				smallest = lt;
			}
			if (rt < size && arr[rt] < arr[smallest]) {
				smallest = rt;
			}
			if (smallest != i) {
				int temp = arr[i];
				arr[i] = arr[smallest];
				arr[smallest] = temp;
				minHeapify(smallest);
			}
		}

//time complexity = O(1) + O(logn) = theta or O(logn) and space complexity: O(logn) if minHeapify is recursive 
//		and O(1) if minHeapify is iterative.
		public int extractMin() {
			if (size <= 0) {
				return Integer.MAX_VALUE;
			}
			if (size == 1) {
				size--;
				return arr[0];
			}
			int temp = arr[0];
			arr[0] = arr[size - 1];
			arr[size - 1] = temp;
			size--;
			minHeapify(0);
			return arr[size];
		}

		// time complexity : O(log(n)) (logn = h) and space complexity(auxillary space)
		// O(1)
		public void decreaseKey(int i, int x) {
			arr[i] = x;
			while (i != 0 && arr[parent(i)] > arr[i]) {
				int temp = arr[i];
				arr[i] = arr[parent(i)];
				arr[parent(i)] = temp;
				i = parent(i);
			}
		}

		// time complexity = O(logn) and space complexity: O(logn) if minHeapify is
		// recursive
//		and O(1) if minHeapify is iterative.
		public void deleteKey(int i) {
			decreaseKey(i, Integer.MIN_VALUE);
			extractMin();
		}
	}

	public static void main(String args[]) {
		MinHeap h = new MinHeap(11);
		h.insert(3);
		h.insert(2);
		h.insert(15);
		h.insert(20);
		System.out.print(h.extractMin());
	}
}
