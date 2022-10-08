package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pair {

    public static int[] findFirstPair(int[] arr, int target) {
        /**
         * 3 Approach
         * 1) brute force N*N (N2) complexity
         * 2) Sort the array and do a binary search O(nlogn)
         * 3) Use a Hash and then find arrays.Pair O(n)
         */

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};

        System.out.println(Arrays.toString(findFirstPair(arr, 9)));
        System.out.println(Arrays.toString(findFirstPair(arr, 15)));
        System.out.println(Arrays.toString(findFirstPair(arr, 20)));
        System.out.println(Arrays.toString(findFirstPair(arr, 6)));
    }
}
