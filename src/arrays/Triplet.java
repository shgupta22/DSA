package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet {
    /**
     * Find All possible combination of triplets
     * 3 Approach
     * 1) Brute force O(N3)
     * 2) Use hash and then apply find arrays.Pair on second half O(n*n) N2 + O(n) space
     * 3) Sort the Array, and then use 2 Pointer approach O(nlogn) + O(n2)
     */

    public static List<List<Integer>> findTriplet(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();



        int n = arr.length;
        for (int i =0; i <= n-3; i++) {
            int j = i+1;
            int k = n-1;

            //two pointer approach
            while (j < k) {
                int currentSum = arr[i];
                currentSum += arr[j];
                currentSum +=arr[k];

                if (currentSum == target) {
                    result.add(List.of(arr[i], arr[j], arr[k]));
                    j++;k--;
                } else if (currentSum > target) {
                    k--;
                } else { //currentSum < target
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};

        System.out.println(findTriplet(arr, 9));
        System.out.println(findTriplet(arr, 10));
        System.out.println(findTriplet(arr, 15));
    }
}
