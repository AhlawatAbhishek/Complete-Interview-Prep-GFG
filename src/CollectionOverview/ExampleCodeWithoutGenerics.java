package CollectionOverview;

class Pair {
	Object x;
	Object y;
}

public class ExampleCodeWithoutGenerics {

	public static void main(String[] args) {
		Pair p = new Pair();
		p.x = 12;
		p.y = "GfG";
		String str = (String) p.x;
	}

}
