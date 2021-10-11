package Recursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printHanoi(2, "A", "B", "C");
	}

	public static void printHanoi(int n, String source, String helper, String destination) {
		if (n == 1) {
			System.out.println("Moving disk " + n + " from " + source + " to " + destination);
			return;
		}
		printHanoi(n - 1, source, destination, helper);
		System.out.println("Moving disk " + n + " from " + source + " to " + destination);
		printHanoi(n - 1, helper, source, destination);
	}

}
