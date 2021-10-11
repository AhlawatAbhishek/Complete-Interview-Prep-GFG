package Queue;

public class FirstCircularTour {
//	Time complexity : O(n^2) and auxiliary space : O(1)
	public static int findPosition(int petrol[], int dist[]) {
		int n = petrol.length;
		for (int start = 0; start < n; start++) {
			int end = start, currPet = 0;
			while (true) {
				currPet += petrol[end] - dist[end];
				if (currPet < 0) {
					break;
				}
				end = (end + 1) % n;
				if (start == end) {
					return start + 1;
				}
			}
		}
		return -1;
	}

////	Time complexity : O(N) and auxiliary space : O(1)
	public static int findPosition2(int petrol[], int dist[]) {
		int n = petrol.length, start = 0, end = 1;
		int currPetrol = petrol[start] - dist[start];
		while (end != start || currPetrol < 0) {
			while (start != end && currPetrol < 0) {
				currPetrol -= petrol[start] - dist[start];
				start = (start + 1) % n;
				if (start == 0) {
					return -1;
				}
			}
			currPetrol += petrol[end] - dist[end];
			end = (end + 1) % n;
		}
		return start + 1;

	}

////Time complexity : O(N) and auxiliary space : O(1)
	public static int findPosition3(int petrol[], int dist[]) {
		int n = petrol.length, prevPetrol = 0, currPetrol = 0, start = 0;
		for (int i = 0; i < n; i++) {
			currPetrol += petrol[i] - dist[i];
			if (currPetrol < 0) {
				start = i + 1;
				prevPetrol += currPetrol;
				currPetrol = 0;
			}
		}
		return (currPetrol + prevPetrol >= 0) ? start + 1 : -1;
	}

	public static void main(String[] args) {
		int petrol[] = new int[] { 4, 6, 7, 4 };
		int dist[] = new int[] { 6, 5, 3, 5 };
		System.out.println(findPosition3(petrol, dist));
	}

}
