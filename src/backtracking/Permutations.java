package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    /**
     *
     * Backtracking
     * 1) Result, TempList, Nums
     * 2) If (TempList.size  == Nums.length) result.add(tempList);
     * 3) else, for (int i=0; i < length; i++)
     * 4)   if (tempList.contains(nums[i]) continue;
     * 5)   tempList.add(nums[i])
     * 6)   backTrack(result, tempList, nums)
     * 7)   tempList.remove(tempList.size()-1);
     *
     * */

    public static List<List<Integer>> permutations(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtack(result, new ArrayList<>(), nums);
        return result;
    }

    public static void backtack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue;
                tempList.add(num);
                backtack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(permutations(new int[]{1,2,3}));
    }
}
