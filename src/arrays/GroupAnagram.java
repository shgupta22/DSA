package arrays;

import java.util.*;

public class GroupAnagram {

    public static List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            if (!map.containsKey(Arrays.toString(chars))) map.put(Arrays.toString(chars), new ArrayList<>());
            map.get(Arrays.toString(chars)).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagram(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
