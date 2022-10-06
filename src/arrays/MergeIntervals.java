package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
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
    }
}
