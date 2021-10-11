package Recursion;

//time complexity : 0/theta(N) and space complexity = O(N) 
public class JosephusProblem {
	static int jos(int n, int k) {
		if (n == 1) {
			return 0;
		}
		return (jos(n - 1, k) + k) % n;
	}

//	use this when idexing of persons starts with one
	static int myJos(int n, int k) {
		return jos(n, k) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myJos(5, 3));
	}

}
