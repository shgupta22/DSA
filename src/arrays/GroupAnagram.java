package arrays;

import java.util.*;

public class GroupAnagram {
    /**
        Approach 1)
        1) For each string sort it lexicographically
        2) Use hashmap to story the sorted string and maintain a list of string
        3) Collect all values from map and return List of List of String

        N length of string array
        k String with max length
        Time: O(N * klogk)
        Space: O(N)

        APPROACH 2) One optimisation
            - Use char[26] array and parse the string (s.charAt(i) - 'a')++
            - the convert this char[26] array to String and map to Key in hashMap
            - this will save the Sorting time for the algo

            Time will be O(n * k)
     **/

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
