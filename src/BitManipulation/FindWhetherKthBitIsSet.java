package BitManipulation;

public class FindWhetherKthBitIsSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 13, k = 3;
//        Using left shift
//		if ((n & (1 << (k - 1))) != 0) {
//			System.out.println("Kth bit is set");
//		} else {
//			System.out.println("Kth bit is not set");
//		}
//         Using right shift
		if ((1 & (n >> (k - 1))) != 0) {
			System.out.println("Kth bit is set");
		} else {
			System.out.println("Kth bit is not set");
		}
	}

}
