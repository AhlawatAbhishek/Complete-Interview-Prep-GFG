package BitManipulation;

public class BinaryToGrayCodeEquivalent {
	public static int greyConverter(int n) {
//https://www.youtube.com/watch?v=R7uuIACpdGQ
		// Your code here
		// eg n = 10 - 1010 (binary)
		// n>>1 - 0101(now XOR of n and n>>1)
		// ans - 1111 = 15
		return (n ^ (n >> 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(greyConverter(10));
	}

}
