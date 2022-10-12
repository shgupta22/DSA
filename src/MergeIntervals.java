import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<int[]> output = new ArrayList<>();

        output.add(intervals[0]);
        for (int i =1; i < intervals.length;i++ ) {
            int lastEnd = output.get(output.size() - 1)[1];
            int[] pair = intervals[i];
            if (pair[0] <= lastEnd) {
                output.get(output.size()-1)[1] = Math.max(lastEnd, pair[1]);
            } else {
                output.add(pair);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
    public static void main(String[] args) {
        int[][] mergeIntervals = mergeIntervals(new int[][]{{1, 3}, {8, 10}, {15, 18}, {2, 6}});
        for (int[] interval: mergeIntervals)
            System.out.println(Arrays.toString(interval));
    }
}
