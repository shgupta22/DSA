package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    /**
     * Backtracking Approach
     *
     * Input: int[] NUMS, int TARGET
     *
     * 1) Result, TempList, Nums, Target, Start
     * 2) If (Target < 0) return;
     * 3) if (Target == 0) Result.add(tempList) return;
     * 4) Else For (i = Start; i< length; i++)
     * 5)   TempList.add(Nums[i]); BackTrack(result, templsit, Nums, Target-Nums[i], i)
     * 6)   TempList.Remove(tempList.size()-1);
     *
     */

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int rem, int start) {
        if (rem < 0) return;
        else if (rem == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length;i++) {
                tempList.add(nums[i]);
                backTrack(result, tempList, nums, rem - nums[i], i); //not i+1 because we can use same element
                tempList.remove(tempList.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1,2,3,4}, 7));
    }
}
