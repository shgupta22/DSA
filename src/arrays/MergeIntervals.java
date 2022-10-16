package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {


    /**
     * Much better approach
     * 1) Sort the intervals based on their first value in a Interval
     * 2) Create Output place the first interval
     * 3) Iterate over the remaining Intervals
     * 4) compare the last interval last value with current Interval[0] if less then merge it
     *
     * Time: O(NlogN + N) sort and iterate
     * Space: No extra except the result space of O(N)
     */
    public static int[][] merge_better(int[][] nums) {
        Arrays.sort(nums, (a,b) -> a[0] - b[0]);

        List<int[]> output = new ArrayList<>();
        output.add(nums[0]);

        for (int i=1; i < nums.length; i++) {
            int lastEnd = output.get(output.size()-1)[1];
            int[] pair = nums[i];

            if (pair[0] <= lastEnd) {
                output.get(output.size()-1)[1] = Math.max(lastEnd, pair[1]);
            } else {
                output.add(pair);
            }
        }

        return output.toArray(new int[output.size()][2]);
    }

    /**
     * This Approach creates 2 arrays of start and end
     * sort both of them, and merge them based on intervals
     *
     * Time : 2 times sort and them merge
     *  O(nlogn + nlogn + n)
     *
     *  Space : O(2n) and if we consider result that will be an extra N
     */

    public static int[][] merge(int[][] nums) {
        int n = nums.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i =0; i< n; i++) {
            start[i] = nums[i][0];
            end[i] = nums[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        List<int[]> intervals = new ArrayList<>();
        for (int i=0, j=0; i < n; i++) {
            if (i == n-1 || start[i+1]>end[i]) {
                intervals.add(new int[]{start[j], end[i]});
                j=i+1;
            }
        }
        return intervals.toArray(new int[intervals.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));
        System.out.println(Arrays.deepToString(merge_better(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));
    }
}
