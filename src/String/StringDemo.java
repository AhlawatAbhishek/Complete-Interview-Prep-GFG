package String;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creates a string literal
		String str = "geeks";

		// Returns the number of
		// characters in the String.
		System.out.println(str.length());

		// Returns the character at ith index.
		System.out.println(str.charAt(3));

		// Return the substring from the
		// ith index character
		// to end of string
		System.out.println(str.substring(2));

		// Returns the substring from i to j-1 index.
		System.out.println(str.substring(2, 5));

//		-------------------------------------
		// Creating two string literals
//		String s1 = "geeksforgeeks";
//		String s2 = "geeks";
//
//		// Returns the first occurrence of
//		// s2 in s1 after index 1
//		System.out.println(s1.indexOf(s2));
//		-------------------------------------
		// Creating two string literals
//		String s1 = "geeksforgeeks";
//		String s2 = "for";
//
//		int res = s1.compareTo(s2);
//
//		if (res == 0)
//			System.out.println("Same");
//
//		if (res > 0)
//			System.out.println("s1 is Greater");
//
//		if (res < 0)
//			System.out.println("s1 is Smaller");
//		--------------------------------------
//		// Creating two string literals
//		String s1 = "geeksforgeeks";
//		String s2 = "geeksforgeeks";
//
//		// Whether s2 equal to s1
//		System.out.println(s1.equals(s2));
//        -------------------------------------------

//		// Creating two string literals
//		String s1 = "geeksforgeeks";
//		String s2 = "geeks";
//
//		// Whether s2 is present in s1 or not
//		// true
//		System.out.println(s1.contains(s2));
//		--------------------------------------------------
		// Creating two string literals
//		String s1 = "geeks";
//		String s2 = "geeks";
//
//		// Checking if both point to the
//		// same object or not
//		if (s1 == s2)
//			System.out.println("Yes");
//		else
//			System.out.println("No");
//
//		// Creating a string using
//		// new operator
//		String s3 = new String("geeks");
//
//		// Checking if both point to the
//		// same object or not
//		if (s1 == s3)
//			System.out.println("Yes");
//		else
//			System.out.println("No");
//		--------------------------------------------------
		// Creating two string literals
		String s1 = "geeks";
		String s2 = s1;

		// Creates a new object "geeksforgeeks"
		// Now s1 points to this new string
		s1 = s1 + "forgeeks";
		// or
		// s1 = s1.concat("forgeeks");

		System.out.println(s1);

		// Since s2 is still pointing
		// to initial "geeks"
		// and s1 is pointing to a new
		// object "geeksforgeeks"
		System.out.println(s1 == s2);
	}

}
