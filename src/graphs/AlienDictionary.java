package graphs;

import java.util.*;

public class AlienDictionary {

    /**
     * There is a new alien language which uses the latin alphabet.
     * However, the order among letters are unknown to you.
     * You receive a list of non-empty words from the dictionary,
     * where words are sorted lexicographically by the rules of this new language.
     * Derive the order of letters in this language.
     *
     *
     * 1) You may assume all letters are in lowercase.
     * 2) The dictionary is invalid, if string a is prefix of string b and b is appear before a.
     * 3) If the order is invalid, return an empty string.
     * 4) There may be multiple valid order of letters, return the smallest in normal lexicographical order.
     * 5) The letters in one string are of the same rank by default and are sorted in Human dictionary order.
     *
     * 1) Build Adjacency List of each character make an entry in Map
     * 2) Iterate over the words for checking if they are in correct order as lexicographically sorted
     *      for (i =0; i < n-1; i++)
     *          w1 = words[i];
     *          w2 = words[i+1];
     *          minLen = main(w1.length, w2.length)
     *
     *          //breaking condition w1.len > w2.len and w1.prefix == w2.prefix
     *          // eg: w1 = apes, w2 = ape NOT CORRECT ORDER
     *          if (w1.len > w2.len && w1.subString(0, minLen) == w2.subString(0, minLen))
     *              return "";
     *          for (int j = 0; j < minLen; j++) {
     *              if (w1.charAt(j) != w2.charAt(j) {
     *                  adj.get(w1.charAt(j)).add(w2.charAt(j));
     *                  break;
     *              }
     *          }
     *
     *
     *          Use Visited Map with Character and a Boolean
     *          Do a DFS search, and if true return "" empty string
     *          or else append each character to result
     *
     */
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();

        for (String word: words) {
            for (Character c: word.toCharArray()) {
                adj.put(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            String w1= words[i];
            String w2= words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j =0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        Map<Character, Boolean> visited = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (Character c: adj.keySet()) {
            if (dfs(c, visited, sb, adj)) return "";
        }
        return sb.reverse().toString();
    }

    public static boolean dfs(Character c, Map<Character, Boolean> visited, StringBuilder sb, Map<Character, Set<Character>> adj) {
        if (visited.containsKey(c)) return visited.get(c);

        visited.put(c, true);

        for(Character nei: adj.get(c)) {
            if (dfs(nei, visited, sb, adj)) return true;
        }


        visited.put(c, false);
        sb.append(c);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
        System.out.println(alienOrder(new String[]{"ba", "bc", "ac", "cab"}));
        System.out.println(alienOrder(new String[]{"cab", "aaa", "aab"}));
    }
}
