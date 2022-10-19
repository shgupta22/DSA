import java.util.*;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a,b) -> {
            if (Objects.equals(b.getValue(), a.getValue())) {
                return a.getKey().compareToIgnoreCase(b.getKey());
            } else {
                return b.getValue() - a.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }

        List<String> result = new ArrayList<>();
        while (k > 0 && !queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();
            result.add(entry.getKey());
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 3));
        System.out.println(topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }
}
