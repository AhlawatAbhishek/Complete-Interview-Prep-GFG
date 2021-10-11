package Stack;

//Both push and pop are O(1) operations and
//space complexity used in them is O(1) but for implementing stack space complexity used is O(N)
class TwoStacks {
	int arr[], cap, top1, top2;

	TwoStacks(int cap) {
		this.cap = cap;
		arr = new int[this.cap];
		top1 = cap / 2 + 1;
		top2 = cap / 2;
	}

	public void push1(int x) {
		if (top1 > 0) {
			top1--;
			arr[top1] = x;
		} else {
			System.out.println("Stack over flow by element" + x);
		}
	}

	public void push2(int x) {
		if (top2 < cap - 1) {
			top2++;
			arr[top2] = x;
		} else {
			System.out.println("Stack over flow by element" + x);
		}
	}

	public int pop1() {
		if (top1 >= cap / 2 + 1) {
			System.out.println("Stack UnderFlow");
			return -1;
		} else {
			int data = arr[top1];
			top1++;
			return data;
		}
	}

	public int pop2() {
		if (top2 < cap / 2 + 1) {
			System.out.println("Stack UnderFlow");
			return -1;
		} else {
			int data = arr[top2];
			top2--;
			return data;
		}
	}
}

public class TwoStacksInArray {
	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks(5);
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
