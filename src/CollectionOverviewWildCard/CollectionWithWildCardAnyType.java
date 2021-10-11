package CollectionOverviewWildCard;

import java.util.ArrayList;

public class CollectionWithWildCardAnyType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<?> al1 = new ArrayList<>();
		ArrayList<EnggStudent> al2 = new ArrayList<>();
		al1 = al2;
	}

}
