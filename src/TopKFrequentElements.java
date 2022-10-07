import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }

        int[] res = new int[k];
        while (k>0) {
            Map.Entry<Integer, Integer> poll = queue.poll();
            res[k-1] = poll.getKey();
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
