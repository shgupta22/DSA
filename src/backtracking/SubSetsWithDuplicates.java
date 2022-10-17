package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsWithDuplicates {

    /**
     * Backtracking
     * 1) Result, TempList, Nums, Start(0)
     * 2) result.add(tempList)
     * 3) for (int i = start; i < length;i++)
     *      if (i > start && nums[i] == nums[i-1]) continue; skip duplicates
     *      tempList.add(nums[i])
     *      backTrack(result, tempList, nums, i+1)
     *      tempList.remove(tempList.size()-1)
     *
     */

    public static List<List<Integer>> subSetsWithDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i< nums.length;i++) {
            if (i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i+1);
            tempList.remove(tempList.size() -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subSetsWithDuplicates(new int[]{1,2,2,3}));
    }
}
