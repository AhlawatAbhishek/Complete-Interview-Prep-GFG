package Stack;

public class StackUsingArray {
	int arr[];
	int cap;
	int top;

	StackUsingArray(int c) {
		top = -1;
		cap = c;
		arr = new int[cap];
	}

//time complexity : O(1)
	public void push(int x) throws Exception {
		if (top == cap - 1) {
			throw new Exception("Stack Overflow");
		}
		top++;
		arr[top] = x;
	}

//time complexity : O(1)
	public int pop() throws Exception {
		if (top == -1) {
			throw new Exception("Stack UnderFlow");
		}
		int res = arr[top];
		top--;
		return res;
	}

//time complexity : O(1)
	public int peek() throws Exception {
		if (top == -1) {
			throw new Exception("Stack UnderFlow");
		}
		return arr[top];
	}

//time complexity : O(1)
	public int size() {
		return top - 1;
	}

//time complexity : O(1)
	public boolean isEmpty() {
		return (top == -1);
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
