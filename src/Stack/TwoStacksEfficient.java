package Stack;

//Both push and pop are O(1) operations and
//space complexity used in them is O(1) but for implementing stack space complexity used is O(N)
class TwoStacks2 {
	int arr[] = null;
	int cap, top1, top2;

	TwoStacks2(int cap) {
		this.cap = cap;
		arr = new int[this.cap];
		top1 = -1;
		top2 = this.cap;
	}

	public void push1(int x) {
		if (top1 < top2 - 1) {
			top1++;
			arr[top1] = x;
		} else {
			System.out.println("Stack Overflow because of element:" + x);
		}
	}

	public void push2(int x) {
		if (top1 < top2 - 1) {
			top2--;
			arr[top2] = x;
		} else {
			System.out.println("Stack Overflow because of element:" + x);
		}
	}

	public int pop1() {
		if (top1 >= 0) {
			int item = arr[top1];
			top1--;
			return item;
		} else {
			System.out.println("Stack Underflow");
			return -1;
		}
	}

	public int pop2() {
		if (top2 < this.cap) {
			int item = arr[top2];
			top2++;
			return item;
		} else {
			System.out.println("Stack Underflow");
			return -1;
		}
	}
}

public class TwoStacksEfficient {

	public static void main(String[] args) {

		TwoStacks2 ts = new TwoStacks2(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		System.out.println("Popped element from stack1 is: " + ts.pop1());
		ts.push2(40);
		System.out.println("Popped element from stack2 is: " + ts.pop2());

	}
}
