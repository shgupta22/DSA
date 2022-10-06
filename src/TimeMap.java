import java.util.*;

class TimeMap {

    Map<String, TreeMap<Integer, String>> kvStore;

    public TimeMap() {
        kvStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!kvStore.containsKey(key)) {
            kvStore.put(key, new TreeMap<>());
        }
        kvStore.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!kvStore.containsKey(key)) return "";
        TreeMap<Integer, String> tmMap = kvStore.get(key);

        Integer floorKey = tmMap.floorKey(timestamp);
        if (floorKey == null) return "";
        return tmMap.get(floorKey);
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap);
        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));

        System.out.println(timeMap);
//        [null,null,null,"","high","high","low","low"]

        /*
        ["TimeMap","set","set","get","get","get","get","get"]
[[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]

         */
    }

    @Override
    public String toString() {
        return "TimeMap{" +
                "kvStore=" + kvStore +
                '}';
    }
}