package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

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
