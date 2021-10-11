package DynamicProgramming;

public class KadanesAlgoIIUsingBottomUpDpOrTabulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public long maximumSum(int arr[], int n)
	  {
	  //Your code here
	  long res[] = new long[n];
	  res[0] = arr[0];
	  res[1] = arr[1];

	  for(int i = 2; i < n; i++){
	  long temp1 = Integer.MIN_VALUE;
	  long temp2 = Integer.MIN_VALUE;

	  if(res[i-2] + arr[i] > res[i-2] && res[i-2] + arr[i] > arr[i])
	  temp1 = res[i-2] + arr[i];
	  else{
	  if(res[i-2] < arr[i])
	  temp1 = arr[i];
	  else
	  temp1 = res[i-2];
	  }

	  if(i-3 >= 0){
	  if(res[i-3] + arr[i] > res[i-3] && res[i-3] + arr[i] > arr[i])
	  temp2 = res[i-3] + arr[i];
	  else{
	  if(res[i-3] < arr[i])
	  temp2 = arr[i];
	  else
	  temp2 = res[i-3];
	  }
	  }

	  res[i] = Math.max(temp1, temp2);
	  }

	  return Math.max(res[n-1], res[n-2]);
	  }
	 /* You are given an array arr of size sizeOfArr. You need to find the maximum sum in the array provided that you cannot sum neighboring elements or adjacent elements.

	  Example 1:

	  Input:
	  sizeOfArr = 4
	  arr[] = {4,5,6,7,8}
	  Output: 18
	  Explanation:The given elements are 4 5 6 7 8
	  For 4, the maximum sum will be 4 as no
	  element other than 4 from index 0 to 0
	  For 5, the maximum sum will be 5 as we cannot
	  add 4 and 5(neighboring elements).
	  For 6, the maximum sum will be 10 as we can
	  add 6 and 4.
	  For 7, the maximum sum will be 12 as we can
	  add 7 and 5.
	  For 8, the maximum sum will be 18 as we can
	  add 4 and 6 and 8.
	  Example 2:

	  Input:
	  sizeOfArr = 5
	  arr[] = {-9,-8,8,3,-4}
	  Output: 8
	  Your Task:
	  This is a function problem. You only need to complete the function maximumSum() that takes array and sizeOfArray and returns the maximum sum of the array provided that you cannot sum neighboring elements.

	  Expected Time Complexity: O(N).
	  Expected Auxiliary Space: O(N).

	  Constraints:
	  1 <= sizeOfArr <= 106*/

}
