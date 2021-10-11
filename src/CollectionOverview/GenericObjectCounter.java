package CollectionOverview;

public class GenericObjectCounter<T> {
	T x;
	static int count;

	GenericObjectCounter() {
		count++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericObjectCounter ob1 = new GenericObjectCounter();
		GenericObjectCounter ob2 = new GenericObjectCounter();
		System.out.println(GenericObjectCounter.count);
	}

}
