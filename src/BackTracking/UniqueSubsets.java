package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSubsets {
	/*
	 * Given an array arr[] of integers of size N that might contain duplicates, the
	 * task is to find all possible unique subsets.
	 * 
	 * Note: Each subset should be sorted.
	 * 
	 * Example 1:
	 * 
	 * Input: N = 3, arr[] = {2,1,2} Output:(),(1),(1 2),(1 2 2),(2),(2 2)
	 * Explanation: All possible subsets = (),(2),(1),(1,2),(2),(2,2),(2,1),(2,1,2)
	 * After Sorting each subset = (),(2),(1),(1,2),(2),(2,2),(1,2),(1,2,2) Unique
	 * Susbsets in Lexicographical order = (),(1),(1,2),(1,2,2),(2),(2,2)
	 * 
	 * Subsequence and subsets - int this question-- are same except subset contains
	 * empty set and subsequence don't
	 */
	public static ArrayList<ArrayList<Integer>> AllSubsets(int nums[], int n) {
		// your code here
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return results;
		}

		Arrays.sort(nums);

		toFindAllSubsets(nums, results, new ArrayList<Integer>(), 0);
		results.remove(0);

		return results;
	}

	private static void toFindAllSubsets(int[] nums, ArrayList<ArrayList<Integer>> results, List<Integer> curr,
			int startIndex) {
		results.add(new ArrayList<>(curr));

		for (int i = startIndex; i < nums.length; i++) {
			if (i != startIndex && nums[i] == nums[i - 1]) {
				continue;
			}

			curr.add(nums[i]);
			toFindAllSubsets(nums, results, curr, i + 1);
			curr.remove(curr.size() - 1);
		}
	}
//	this gives Tle -----------------
//	public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n){
//        // your code here
//        ArrayList <ArrayList <Integer>> al = new ArrayList<>();
//        generateSubset(arr, 0, al, new ArrayList<Integer>());
//        Collections.sort(al, (a, b) -> {
//                        
//                        String sa = "" , sb ="";
//                        for(int i : a){
//                            sa = sa+Integer.toString(i);
//                        }
//                        for(int i : b){
//                            sb = sb+Integer.toString(i);
//                        }
//                        return sa.compareTo(sb);
//                                        });
//        return al;
//    }
//    public static void generateSubset(int arr[], int index, ArrayList <ArrayList <Integer>> res,
//                                   ArrayList<Integer>curr){
//          if(index == arr.length){
//           if(curr.size() >0){
//                   ArrayList<Integer> ai = new ArrayList<>(curr);
//                   Collections.sort(ai);
//                   if(!res.contains(ai))res.add(ai);
//           }     
//              return;
//          }       
//          generateSubset(arr, index+1, res, curr);
//          curr.add(arr[index]);
//          generateSubset(arr, index+1, res, curr);
//          if(curr.size() > 0)curr.remove(curr.size()-1);
//    }
}
