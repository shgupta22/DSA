package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumDifference {


    /**
     * Finding Pair of I, J from 2 Array such that their difference is minimum
     *
     * 1) Create a Pair of value and Index to preserve the original Indexes
     * 2) Create 2 List of Pairs with Value and Index
     * 3) Sort both the Paris array by value
     * 4) Take to pointer A and B and MinDiff
     * 5) Check if Abs(P1[A].value - P2[B].value) < diff, if then then update diff
     * 6) Finally increment Pointer, if (P1[A].value < P2[B].value) ? A++ : B++
     */

    //Preserve original indexes

    static class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    private static int[] minDiff(int[] arr1, int[] arr2) {
        Pair[] P1 = new Pair[arr1.length];
        for (int i=0; i < arr1.length; i++) {
            P1[i] = new Pair(arr1[i], i);
        }

        Pair[] P2 = new Pair[arr2.length];
        for(int i =0; i < arr2.length;i++) {
            P2[i] = new Pair(arr2[i], i);
        }

        Arrays.sort(P1, Comparator.comparingInt(o -> o.val));
        Arrays.sort(P2, Comparator.comparingInt(o -> o.val));

        int a = 0; int b = 0;
        int diff = Integer.MAX_VALUE;
        int i =0,j= 0;

        while (a < P1.length && b < P2.length) {
            if (Math.abs(P1[a].val - P2[b].val) < diff) {
                diff = Math.abs(P1[a].val - P2[b].val);
                i = P1[a].index; j = P2[b].index;
            }

            if (P1[a].val < P2[b].val) {
                a++;
            } else {
                b++;
            }
        }
        return new int[]{i,j};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 11, 5};
        int[] arr2 = {4, 12, 19, 23, 127, 235};

        System.out.println(Arrays.toString(minDiff(arr1, arr2)));
    }
}
