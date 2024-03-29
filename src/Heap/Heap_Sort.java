package Heap;

import java.util.Scanner;
// Time Complexity: O(N * Log(N)).
// Auxiliary Space:O(1).

public class Heap_Sort {

	void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Heap_Sort hs = new Heap_Sort();
		int arr[] = new int[1000000];
		int T = sc.nextInt();
		while (T > 0) {
			int n = sc.nextInt();
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			hs.heapSort(arr, n);
			hs.printArray(arr, n);
			T--;
		}
	}

	public void heapSort(int arr[], int n) {
		GfG g = new GfG();
		g.buildHeap(arr, n);
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			g.heapify(arr, i, 0);
		}
	}
}

//} Driver Code Ends

class GfG {
//  void buildHeap(int arr[], int n)
// {
//   for(int i= (n/2) -1 ; i>=0 ;i--)
//         heapify(arr,n,i);
// }

// void heapify(int arr[], int n, int i)
// {
//   int largest = i; // i -> parent node.
//   int l  = 2*i+1; //l-> left child of i.
//   int r = 2*i+2; //r -> right child of i.

//   if(l<n && arr[l] > arr[largest])
//     largest = l;

//   if(r<n && arr[r] > arr[largest])
//     largest = r;

//   if(largest!=i)
//   {
//     int temp  = arr[largest];
//     arr[largest] = arr[i];
//     arr[i] = temp;

//     heapify(arr,n,largest); //Here the root is passed as largest.
//   }
// }
	void buildHeap(int arr[], int n) {
// Your code here
		for (int i = (n - 2) / 2; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

// To heapify a subtree rooted with node i which is
// an index in arr[]. n is size of heap
	int left(int i) {
		return 2 * i + 1;
	}

	int right(int i) {
		return 2 * i + 2;
	}

	void heapify(int arr[], int n, int i) {
// Your code here
		int lt = left(i);
		int rt = right(i);
		int largest = i;
		if (lt < n && arr[lt] > arr[largest]) {
			largest = lt;
		}
		if (rt < n && arr[rt] > arr[largest]) {
			largest = rt;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);

		}
	}
}
