package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash {
	int Bucket;
	ArrayList<LinkedList<Integer>> table;

	MyHash(int b) {
		Bucket = b;
		table = new ArrayList<LinkedList<Integer>>();
		for (int i = 0; i < b; i++) {
			table.add(new LinkedList<Integer>());
		}
	}

	public void insert(Integer key) {
		int i = key % Bucket;
		table.get(i).add(key);
	}

	void delete(Integer key) {
		int i = key % Bucket;
		table.get(i).remove(key);
	}

	boolean search(Integer key) {
		int i = key % Bucket;
		return table.get(i).contains(key);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHash mh = new MyHash(7);
		mh.insert(10);
		mh.insert(20);
		mh.insert(15);
		mh.insert(7);
		System.out.println(mh.search(10));
//		mh.delete(15);
		System.out.println(mh.search(15));
	}

}
