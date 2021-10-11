package BitManipulation;

public class CheckIfANumberIsPowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 1024, n2 = 843;
		System.out.println(isPowerOfTwo1(n1));
		System.out.println(isPowerOfTwo2(n1));
		System.out.println(isPowerOfTwo3(n1));
	}

	public static boolean isPowerOfTwo1(int n) {
		while (n != 1) {
			if (n % 2 != 0) {
				return false;
			}
			n = n / 2;
		}
		return true;
	}

	public static boolean isPowerOfTwo2(int n) {
//    	power of two have only one bit set
		int countSetBits = 0;
		while (n > 0) {
			countSetBits++;
			n = n & (n - 1);
		}
		return countSetBits == 1;
	}

	public static boolean isPowerOfTwo3(int n) {
		if (n == 0) {
			return false;
		}
		return (n & (n - 1)) == 0;
	}
}
