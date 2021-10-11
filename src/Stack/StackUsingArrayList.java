package Stack;

import java.util.ArrayList;

public class StackUsingArrayList {

	ArrayList<Integer> al = new ArrayList<>();

//time complexity : O(1) amortized or average case
	public void push(int x) {
		al.add(x);
	}

//time complexity : O(1) amortized or average case
	public int pop() {
		int res = al.get(al.size() - 1);
		al.remove(al.size() - 1);
		return res;
	}

//time complexity : O(1) amortized or average case
	public int peek() {
		return al.get(al.size() - 1);
	}

//time complexity : O(1) amortized or average case
	public int size() {
		return al.size();
	}

//time complexity : O(1) amortized or average case
	public boolean isEmpty() {
		return al.isEmpty();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StackUsingArray stack = new StackUsingArray(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.pop());
	}

}
