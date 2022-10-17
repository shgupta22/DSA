package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /**
     * Backtrack
     * 1) Result, TempList, Nums, Start(0)
     * 2) result.add(tempList)
     * 3) else, for (i = start; i < length; i++) tempList.add(nums[i])
     * 4)       backTrack(result, tempList, nums, i+1)
     * 5)       tempList.remove(tempList.size() -1)
     */

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(result, tempList, nums, i+1);
            tempList.remove(tempList.size() -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3,4}));
    }
}
