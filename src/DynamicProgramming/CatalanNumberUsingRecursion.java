package DynamicProgramming;

public class CatalanNumberUsingRecursion {
//	Time Complexity : Exponential 
	public static int catalan(int num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < num; i++) {
			res += catalan(i) * catalan(num - i - 1);
		}
		return res;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(catalan(i) + " ");
		}
	}
}
