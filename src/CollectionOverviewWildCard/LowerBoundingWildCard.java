package CollectionOverviewWildCard;

import java.util.ArrayList;

public class LowerBoundingWildCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<? super Student> al1 = new ArrayList<>();
		ArrayList<Object> al2 = new ArrayList<>();
		al1 = al2;
	}

}
