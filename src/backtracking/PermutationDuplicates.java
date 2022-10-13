package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationDuplicates {

    //Will return Unique combination
    public static List<List<Integer>> permutationWithDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] visited) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(visited[i] || i >0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
                visited[i] = true;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, visited);
                visited[i] = false;
                tempList.remove(tempList.size() -1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permutationWithDuplicates(new int[]{1,2,2,3}));
    }
}
