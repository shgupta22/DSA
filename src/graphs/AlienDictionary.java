package graphs;

import java.util.*;

public class AlienDictionary {

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
    }
}
