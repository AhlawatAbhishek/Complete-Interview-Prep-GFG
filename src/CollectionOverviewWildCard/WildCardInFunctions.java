package CollectionOverviewWildCard;

import java.util.ArrayList;

class MgmtStudent extends Student {
	void print() {
		System.out.println("Mgmt student");
	}
}

public class WildCardInFunctions {

	static void printStudents(ArrayList<? extends Student> al) {
		{
			for (Student s : al) {
				s.print();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<EnggStudent> al1 = new ArrayList<>();
		al1.add(new EnggStudent());
		al1.add(new EnggStudent());
		ArrayList<MgmtStudent> al2 = new ArrayList<>();
		al2.add(new MgmtStudent());
		printStudents(al1);
		printStudents(al2);

	}

}
