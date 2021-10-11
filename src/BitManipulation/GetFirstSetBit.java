package BitManipulation;

public class GetFirstSetBit {
	public static int getFirstSetBit(int n) {

		// Your code here
		if (n == 0) {
			return 0;
		}
		int a = n ^ (n - 1);
		double x = Math.log(2);
		double y = Math.log((a + 1));
		int res = (int) (y / x);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFirstSetBit(12));
	}

}
