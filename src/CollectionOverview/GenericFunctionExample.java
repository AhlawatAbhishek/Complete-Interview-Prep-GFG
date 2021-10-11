package CollectionOverview;

public class GenericFunctionExample {
	public static <T> int count(T arr[], T x) {
		int res = 0;
		for (T a : arr) {
			if (a.equals(x)) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[] = { 10, 20, 30, 40, 10, 30 };
		System.out.println(count(arr, 10));
	}

}
