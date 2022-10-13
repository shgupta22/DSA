package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

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
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtack(result, tempList, nums);
                tempList.remove(tempList.size() -1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(permutations(new int[]{1,2,3}));
    }
}
