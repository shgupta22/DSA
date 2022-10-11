import java.util.Arrays;
import java.util.PriorityQueue;

public class KPointsNearToOrigin {

    public static int[][] kPoints(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> distance(a) - distance(b));

        for (int[] pair: points) {
            heap.add(pair);
        }

        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = heap.poll();
        }
        return result;
    }

    public static int distance(int[] a) {
        return a[0]*a[0] + a[1]*a[1];
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,3},{3,4},{-2,3},{2,-1}};
        System.out.println(Arrays.deepToString(kPoints(points, 2)));
    }
}
