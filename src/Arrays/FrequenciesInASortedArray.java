package Arrays;

public class FrequenciesInASortedArray {
//Time complexity: 0(N) and auxiliary space : 0(1)
	public static void printFreq(int arr[], int n) {
		int i = 1;
		while (i < n) {
			int freq = 1;
			while (i < n && arr[i] == arr[i - 1]) {
				i++;
				freq++;
			}
			System.out.println(arr[i - 1] + " => " + freq);
			i++;
		}
		if (arr[n - 1] != arr[n - 2] || i == 1) {
			System.out.println(arr[n - 1] + " => " + "1");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 10, 20, 30, 30, 30, 40 }, n = 7;

		printFreq(arr, n);

	}

}
