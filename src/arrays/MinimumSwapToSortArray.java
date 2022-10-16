package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MinimumSwapToSortArray {

    /**
     * Minimum Swaps to sort the array
     *
     * 1) Create Pair array with current Index and Value
     * 2) Sort the Pair array
     * 3) Iterate over the Pair array from current index to prev index of Pair[i], until you find cycle
     * 4) Use visited set to store the visited nodes
     * 5) Keep count and increment until cycle is complete
     * 6) Add the count to Ans and move to next index
     *
     * Time: O(NlogN + N)
     * Space: O(N)
     */

    static class Pair{
        public int val;
        public int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static int minSwap(int[] arr) {

        //Know the actual Position of element (sorting)
        //store current indices
        Pair[] pairs = new Pair[arr.length];
        for (int i =0; i < arr.length;i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        //sort the array
        Arrays.sort(pairs, Comparator.comparingInt(o -> o.val));

        //build the logic
        Set<Pair> visited = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < pairs.length; i++) {
            //if element is visited or element is in right position
            int oldPosition = pairs[i].index;
            if (visited.contains(pairs[i]) || oldPosition == i ) {
                continue;
            }

            //visiting the element (index) for first time
            int cycle = 0;
            int idx = i;
            while(!visited.contains(pairs[idx])) {
                visited.add(pairs[idx]);
                idx = pairs[idx].index;
                cycle++;
            }
            ans+=cycle-1;
        }
        return ans;

    }


    public static void main(String[] args) {
        int[] arr = new int[]{10,11,5,4,3,2,1};
        System.out.println(minSwap(arr));

        System.out.println(minSwap(new int[]{5,4,3,2,1,0}));
    }
}
