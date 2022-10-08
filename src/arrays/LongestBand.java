package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestBand {
    /**
     * Subset of array which have maximum number of consecutive numbers
     * return max-length
     *
     * Approach
     * 1) Sort O(nlogn) + O(n)
     * 2) Use HashSet and look for Start of any number look for N-1 value if present or not
     *
     * It looks like it have O(N2) complexity but
     * its O(n+n) => O(n)
     *
     * for internal part we are iterating in small part and summing all them up will be equal to N
     *   x+y+z+a+b = N
     */

    public static int longestBand(int[] arr) {
        int n = arr.length;

        Set<Integer> set = new HashSet<>();

        for (int num: arr) {
            set.add(num);
        }

        int maxBand = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int cnt = 1;
                int nextNum = num + 1;
                while (set.contains(nextNum)) {
                    nextNum++;
                    cnt++;
                }
                maxBand = Math.max(maxBand, cnt);
            }
        }
        return maxBand;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,9,3,0,18,5,2,4,10,7,12,6};
        System.out.println(longestBand(arr));

        int[] arr1 = new int[]{9,3,4,5,6,7,0,1,2,8,10};
        System.out.println(longestBand(arr1));
    }
}
