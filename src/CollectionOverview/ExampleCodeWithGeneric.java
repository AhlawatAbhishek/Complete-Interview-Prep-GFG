package CollectionOverview;

class Pair<T, S> {
	T x;
	S y;
}

public class ExampleCodeWithGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<Integer, String> p = new Pair<>();
		p.x = 12;
		p.y = "GFG";
		String str = (String) p.x;
	}

}
