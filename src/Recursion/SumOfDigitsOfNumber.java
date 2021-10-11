package Recursion;

public class SumOfDigitsOfNumber {

	public static void main(String[] args) {
		int n = 25;
		System.out.println(sum(n));
	}

	public static int sum(int n) {
		if (n < 10) {
			return n;
		}
		return sum(n / 10) + n % 10;
	}
}
