package DynamicProgramming;

public class EggDropProblemUsingRecursion {
//	Time complexity : O(2^floors) 
	static int eggDrop(int eggs, int floor) {
		if (floor == 1 || floor == 0) {
			return floor;
		}
		if (eggs == 1) {
			return floor;
		}
		int min = Integer.MAX_VALUE;
		int x, res;
		for (int f = 1; f <= floor; f++) {
//    	taking max of below two situations because we have to think of the worst case situation
//    		                   egg breaks             egg does not breaks
			res = Math.max(eggDrop(eggs - 1, f - 1), eggDrop(eggs, floor - f));
			if (res < min) {
				min = res;
			}
		}
		return min + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int eggs = 2, floor = 10;
		System.out.print("Minimum number of " + "trials in worst case with " + eggs + " eggs and " + floor
				+ " floors is " + eggDrop(eggs, floor));
	}

}
