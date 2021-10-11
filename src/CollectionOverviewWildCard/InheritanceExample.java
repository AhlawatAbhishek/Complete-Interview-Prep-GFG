package CollectionOverviewWildCard;

class Student {
	void print() {
		System.out.println("Student");
	}
}

class EnggStudent extends Student {
	void print() {
		System.out.println("Engg Student");
	}
}

public class InheritanceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		EnggStudent s2 = new EnggStudent();

		s1 = s2;
	}

}
